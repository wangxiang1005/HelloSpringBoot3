package com.paladin.sms.starter.service;

public interface SmsService {
    String send(String fromPhone, String toPhone, String content);
}