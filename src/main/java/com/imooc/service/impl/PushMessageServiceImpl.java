package com.imooc.service.impl;

import com.imooc.config.WechatAccoutConfig;
import com.imooc.config.WechatMpConfig;
import com.imooc.dto.OrderDTO;
import com.imooc.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hasee on 2017/10/16.
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService{

    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private WechatAccoutConfig wechatAccoutConfig;

    /**
     * 微信消息模板推送
     * @param orderDTO
     */
    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(wechatAccoutConfig.getTemplateId().get("orderStatus"));
        templateMessage.setToUser(orderDTO.getBuyerOpenid());

        List<WxMpTemplateData> data = Arrays.asList(
            new WxMpTemplateData("first", "亲，请记得收货。"),
            new WxMpTemplateData("keyword1", "微信点餐"),
            new WxMpTemplateData("keyword2", "18868812345"),
            new WxMpTemplateData("keyword3", orderDTO.getOrderId()),
            new WxMpTemplateData("keyword4", orderDTO.getOrderStatusEnum().getMessage()),
            new WxMpTemplateData("keyword5", "￥" + orderDTO.getOrderAmount()),
            new WxMpTemplateData("remark", "欢迎再次光临！")
        );
        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败,{}",e);
        }
    }
}
