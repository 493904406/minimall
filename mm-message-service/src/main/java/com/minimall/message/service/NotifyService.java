package com.minimall.message.service;

import org.springframework.scheduling.annotation.Async;

public interface NotifyService {
    boolean isMailEnable();

    boolean isSmsEnable();

    boolean isWxEnable();

    /**
     * 短信消息通知
     *
     * @param phoneNumber 接收通知的电话号码
     * @param message     短消息内容，这里短消息内容必须已经在短信平台审核通过
     */
    @Async
    void notifySms(String phoneNumber, String message);

    /**
     * 短信模版消息通知
     *
     * @param phoneNumber 接收通知的电话号码
     * @param notifyType  通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params      通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     */
    @Async
    void notifySmsTemplate(String phoneNumber, NotifyType notifyType, String[] params);

    /**
     * 以同步的方式发送短信模版消息通知
     *
     * @param phoneNumber 接收通知的电话号码
     * @param notifyType  通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params      通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     * @return
     */
    SmsResult notifySmsTemplateSync(String phoneNumber, NotifyType notifyType, String[] params);

    /**
     * 微信模版消息通知,不跳转
     * <p>
     * 该方法会尝试从数据库获取缓存的FormId去发送消息
     *
     * @param touser     接收者openId
     * @param notifyType 通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params     通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     */
    @Async
    void notifyWxTemplate(String touser, NotifyType notifyType, String[] params);

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
    @Async
    void notifyWxTemplate(String touser, NotifyType notifyType, String[] params, String page);

    /**
     * 邮件消息通知,
     * 接收者在spring.mail.sendto中指定
     *
     * @param subject 邮件标题
     * @param content 邮件内容
     */
    @Async
    void notifyMail(String subject, String content);


    void setMailSender(MailSender mailSender);

    void setSendFrom(String sendFrom);

    void setSendTo(String sendTo);

    void setSmsSender(SmsSender smsSender);

    void setSmsTemplate(List<Map<String, String>> smsTemplate);

    void setWxTemplateSender(WxTemplateSender wxTemplateSender);

    void setWxTemplate(List<Map<String, String>> wxTemplate);
}
