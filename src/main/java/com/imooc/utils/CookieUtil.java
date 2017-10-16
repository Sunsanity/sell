package com.imooc.utils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hasee on 2017/10/15.
 */
public class CookieUtil {

    public static void set(HttpServletResponse response,String name,String value,int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 根据name获取cookie
     * @param request
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else {
            return null;
        }
    }

    /**
     * 将request中的cookies转换成map<cookie名,cookie>
     * @param request
     * @return
     */
    public static Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Map<String,Cookie> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie:cookies){
                map.put(cookie.getName(),cookie);
            }
        }
        return map;
    }
}
