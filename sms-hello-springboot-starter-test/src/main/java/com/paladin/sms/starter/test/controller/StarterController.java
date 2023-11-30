package com.paladin.sms.starter.test.controller;

import com.paladin.sms.starter.SmsTemplate;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class StarterController {

    @Resource
    private SmsTemplate smsTemplate;

    @RequestMapping("/send")
    public String sms(){
        String fromPhone = "15522834580";
        String toPhone = "13820345839";
        String content = "Hello, 今晚王者峡谷六点, 五缺一, 收到请回复, over！";
        return smsTemplate.send(fromPhone,toPhone,content);
    }
}