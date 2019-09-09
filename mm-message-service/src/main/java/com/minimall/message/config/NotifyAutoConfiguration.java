package com.minimall.message.config;

import com.github.qcloudsms.SmsSingleSender;
import com.minimall.message.service.impl.TencentSmsSender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/7
 * @mail yxb_825@163.com
 */
@Configuration
@EnableConfigurationProperties(NotifyProperties.class)
public class NotifyAutoConfiguration {
    private final Log logger = LogFactory.getLog(NotifyAutoConfiguration.class);

    @Autowired
    private final NotifyProperties properties;

    public NotifyAutoConfiguration(NotifyProperties properties) {
        this.properties = properties;
    }


    @Bean
    public JavaMailSender mailSender() {
        NotifyProperties.Mail mailConfig = properties.getMail();
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailConfig.getHost());
        mailSender.setUsername(mailConfig.getUsername());
        mailSender.setPassword(mailConfig.getPassword());
        return mailSender;
    }

    @Bean
    public TencentSmsSender tencentSmsSender() {
        NotifyProperties.Sms smsConfig = properties.getSms();
        TencentSmsSender smsSender = new TencentSmsSender();
        smsSender.setSender(new SmsSingleSender(smsConfig.getAppid(), smsConfig.getAppkey()));
        return smsSender;
    }
}
