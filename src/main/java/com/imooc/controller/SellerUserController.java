package com.imooc.controller;

import com.imooc.config.ProjectUrlConfig;
import com.imooc.constant.CookieConstant;
import com.imooc.constant.RedisConstant;
import com.imooc.dataobject.SellerInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.service.SellerService;
import com.imooc.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by hasee on 2017/10/15.
 */
@Controller
@RequestMapping("/seller")
    public class SellerUserController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 卖家登录方法
     * @param openId
     * @param response
     * @param map
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openId")String openId, HttpServletResponse response,Map<String,Object> map){
        //1.查询登陆者的openid和数据库中是否一致
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openId);
        if (sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_ERROR.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        //2.设置token进redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),token,expire, TimeUnit.SECONDS);

        //3.设置token进cookie
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");
    }

    /**
     * 用户退出登录功能
     * @param request
     * @param response
     * @param map
     * @return
     */
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response,Map<String,Object> map){
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if (cookie!=null){
            //将redis中的token删除
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            //将cookie中的token删除
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
}
