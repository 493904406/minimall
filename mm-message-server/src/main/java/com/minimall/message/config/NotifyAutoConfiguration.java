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

    private final NotifyProperties properties;

    public NotifyAutoConfiguration(NotifyProperties properties) {
        this.properties = properties;
    }


    @Bean
    public JavaMailSender mailSender() {
        NotifyProperties.Mail mailConfig = properties.getMail();
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.163.com");
        mailSender.setUsername("yxb_825@163.com");
        mailSender.setPassword("xubin825");
        return mailSender;
    }

    @Bean
    public TencentSmsSender tencentSmsSender() {
        NotifyProperties.Sms smsConfig = properties.getSms();
        TencentSmsSender smsSender = new TencentSmsSender();
        smsSender.setSender(new SmsSingleSender(1400254596, "4d0c9dfd2b1349c1e39c060e1a6ca5e6"));
        return smsSender;
    }
}
