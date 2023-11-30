package com.paladin.sms.starter;

import com.paladin.sms.starter.service.SmsService;
import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;

public class SmsTemplate {

    @Resource
    private SmsProperties smsProperties;

    @Resource
    private ApplicationContext context;

    public String send(String fromPhone,String toPhone,String content){
        //获取云厂商的业务实现类
        String type = smsProperties.getType();
        SmsService smsService = (SmsService)context.getBean(type);
        return smsService.send(fromPhone, toPhone, content);
    }
}