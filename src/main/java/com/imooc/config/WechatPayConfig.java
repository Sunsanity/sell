package com.imooc.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by hasee on 2017/9/21.
 */
@Component
public class WechatPayConfig {

    @Autowired
    private WechatAccoutConfig wechatAccoutConfig;

    @Bean
    public BestPayServiceImpl bestPayService(){
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(wxPayH5Config());
        return bestPayService;
    }

    @Bean
    public WxPayH5Config wxPayH5Config(){
        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(wechatAccoutConfig.getMpAppId());
        wxPayH5Config.setAppSecret(wechatAccoutConfig.getMpAppSecret());
        wxPayH5Config.setMchId(wechatAccoutConfig.getMchId());
        wxPayH5Config.setMchKey(wechatAccoutConfig.getMchKey());
        wxPayH5Config.setKeyPath(wechatAccoutConfig.getKeyPath());
        return wxPayH5Config;
    }
}
