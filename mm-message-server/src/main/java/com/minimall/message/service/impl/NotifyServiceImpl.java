package com.minimall.message.service.impl;
import com.github.qcloudsms.SmsSingleSender;
import com.minimall.message.domain.SmsResult;
import com.minimall.common.enums.NotifyType;
import com.minimall.message.service.NotifyService;
import com.minimall.message.service.SmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yanxubin
 * @Description 商城通知服务类
 * @date:2019/9/2
 * @mail yxb_825@163.com
 */
@Service
public class NotifyServiceImpl implements NotifyService {
    private MailSender mailSender;
    private String sendFrom;
    private String sendTo;
    private SmsSenderService smsSender;
    private List<Map<String, String>> smsTemplate = new ArrayList<>();
    private WxTemplateSender wxTemplateSender;
    private List<Map<String, String>> wxTemplate = new ArrayList<>();

    @Override
    public boolean isMailEnable() {
        return mailSender != null;
    }
    @Override
    public boolean isSmsEnable() {
        return smsSender != null;
    }
    @Override
    public boolean isWxEnable() {
        return wxTemplateSender != null;
    }

    /**
     * 短信消息通知
     *
     * @param phoneNumber 接收通知的电话号码
     * @param message     短消息内容，这里短消息内容必须已经在短信平台审核通过
     */
    @Override
    @Async
    public void notifySms(String phoneNumber, String message) {
        if (smsSender == null){
            return;
        }
        smsSender.send(phoneNumber, message);
    }

    /**
     * 短信模版消息通知
     *
     * @param phoneNumber 接收通知的电话号码
     * @param notifyType  通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params      通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     */
    @Override
    @Async
    public void notifySmsTemplate(String phoneNumber, NotifyType notifyType, String[] params) {
        if (smsSender == null) {
            return;
        }

        String templateIdStr = getTemplateId(notifyType, smsTemplate);
        if (templateIdStr == null) {
            return;
        }

        int templateId = Integer.parseInt(templateIdStr);
        smsSender.sendWithTemplate(phoneNumber, templateId, params);
    }

    /**
     * 以同步的方式发送短信模版消息通知
     *
     * @param phoneNumber 接收通知的电话号码
     * @param notifyType  通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params      通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     * @return
     */
    @Override
    public SmsResult notifySmsTemplateSync(String phoneNumber, NotifyType notifyType, String[] params) {
        if (smsSender == null){
            return null;
        }
        int templateId = Integer.parseInt(getTemplateId(notifyType, smsTemplate));

        return smsSender.sendWithTemplate(phoneNumber, templateId, params);
    }

    /**
     * 微信模版消息通知,不跳转
     * <p>
     * 该方法会尝试从数据库获取缓存的FormId去发送消息
     *
     * @param touser     接收者openId
     * @param notifyType 通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params     通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     */
    @Override
    @Async
    public void notifyWxTemplate(String touser, NotifyType notifyType, String[] params) {
        if (wxTemplateSender == null){
            return;
        }
        String templateId = getTemplateId(notifyType, wxTemplate);
        wxTemplateSender.sendWechatMsg(touser, templateId, params);
    }

    /**
     * 微信模版消息通知，带跳转
     * <p>
     * 该方法会尝试从数据库获取缓存的FormId去发送消息
     *
     * @param touser     接收者openId
     * @param notifyType 通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params     通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     * @param page       点击消息跳转的页面
     */
    @Override
    @Async
    public void notifyWxTemplate(String touser, NotifyType notifyType, String[] params, String page) {
        if (wxTemplateSender == null){
            return;
        }
        String templateId = getTemplateId(notifyType, wxTemplate);
        wxTemplateSender.sendWechatMsg(touser, templateId, params, page);
    }

    /**
     * 邮件消息通知,
     * 接收者在spring.mail.sendto中指定
     *
     * @param subject 邮件标题
     * @param content 邮件内容
     */
    @Override
    @Async
    public void notifyMail(String subject, String content) {
        if (mailSender == null){
            return;
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sendFrom);
        message.setTo(sendTo);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    private String getTemplateId(NotifyType notifyType, List<Map<String, String>> values) {
        for (Map<String, String> item : values) {
            String notifyTypeStr = notifyType.getType();

            if (item.get("name").equals(notifyTypeStr)){
                return item.get("templateId");
            }
        }
        return null;
    }

}
