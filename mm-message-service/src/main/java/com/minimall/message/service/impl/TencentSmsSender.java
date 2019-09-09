package com.minimall.message.service.impl;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.minimall.message.config.NotifyProperties;
import com.minimall.message.domain.SmsResult;
import com.minimall.message.service.SmsSenderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author yanxubin
 * @Description 腾讯云短信服务
 * @date:2019/9/2
 * @mail yxb_825@163.com
 */
public class TencentSmsSender implements SmsSenderService {
    private final Log logger = LogFactory.getLog(TencentSmsSender.class);

    private SmsSingleSender sender;

    public SmsSingleSender getSender() {
        return sender;
    }

    public void setSender(SmsSingleSender sender) {
        this.sender = sender;
    }


    @Override
    public SmsResult send(String phone, String content) {
        try {
            logger.info("##phone:"+ phone + "content:" + content);
            SmsSingleSenderResult result = sender.send(0, "86", phone, content, "", "");
            logger.info(result);

            SmsResult smsResult = new SmsResult();
            smsResult.setSuccessful(true);
            smsResult.setResult(result);
            return smsResult;
        } catch (HTTPException | IOException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    @Override
    public SmsResult sendWithTemplate(String phone, int templateId, String[] params) {
        try {
            SmsSingleSenderResult result = sender.sendWithParam("86", phone, templateId, params, "", "", "");
            logger.debug(result);

            SmsResult smsResult = new SmsResult();
            smsResult.setSuccessful(true);
            smsResult.setResult(result);
            return smsResult;
        } catch (HTTPException | IOException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
}
