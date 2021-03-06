package com.minimall.message.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateData;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateMessage;
import com.minimall.db.domain.LitemallUserFormid;
import com.minimall.db.service.LitemallUserFormIdService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanxubin
 * @Description 微信模版消息通知
 * @date:2019/9/2
 * @mail yxb_825@163.com
 */
@Service
public class WxTemplateSender {
    private final Log logger = LogFactory.getLog(WxTemplateSender.class);

    @Autowired
    private WxMaService wxMaService;

    @Autowired
    private LitemallUserFormIdService formIdService;

    /**
     * 发送微信消息(模板消息),不带跳转
     *
     * @param touser    用户 OpenID
     * @param templatId 模板消息ID
     * @param parms     详细内容
     */
    public void sendWechatMsg(String touser, String templatId, String[] parms) {
        sendMsg(touser, templatId, parms, "", "");
    }

    /**
     * 发送微信消息(模板消息),带跳转
     *
     * @param touser    用户 OpenID
     * @param templatId 模板消息ID
     * @param parms     详细内容
     * @param page      跳转页面
     */
    public void sendWechatMsg(String touser, String templatId, String[] parms, String page) {
        sendMsg(touser, templatId, parms, page, "");
    }

    private void sendMsg(String touser, String templatId, String[] parms, String page, String emphasisKeyword) {
        LitemallUserFormid userFormid = formIdService.queryByOpenId(touser);
        if (userFormid == null){return;}
        WxMaTemplateMessage msg = new WxMaTemplateMessage();
        msg.setTemplateId(templatId);
        msg.setToUser(touser);
        msg.setFormId(userFormid.getFormid());
        msg.setPage(page);
        msg.setEmphasisKeyword(emphasisKeyword);
        msg.setData(createMsgData(parms));

        try {
            wxMaService.getMsgService().sendTemplateMsg(msg);
            if (formIdService.updateUserFormId(userFormid) == 0) {
                logger.warn("更新数据已失效");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private List<WxMaTemplateData> createMsgData(String[] parms) {
        List<WxMaTemplateData> dataList = new ArrayList<WxMaTemplateData>();
        for (int i = 1; i <= parms.length; i++) {
            dataList.add(new WxMaTemplateData("keyword" + i, parms[i - 1]));
        }

        return dataList;
    }
}
