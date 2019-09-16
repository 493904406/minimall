package com.minimall.message.domain;

/**
 * @author yanxubin
 * @Description 发送短信的返回结果
 * @date:2019/9/2
 * @mail yxb_825@163.com
 */
public class SmsResult {
    private boolean successful;
    private Object result;

    /**
     * 短信是否发送成功
     *
     * @return
     */
    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
