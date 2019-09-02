package com.minimall.message.service.impl;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.minimall.message.domain.SmsResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

/**
 * @author yanxubin
 * @Description 腾讯云短信服务
 * @date:2019/9/2
 * @mail yxb_825@163.com
 */
public class TencentSmsSender implements SmsSender {
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
            SmsSingleSenderResult result = sender.send(0, "86", phone, content, "", "");
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
