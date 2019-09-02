package com.minimall.message.service;


import com.minimall.message.domain.entity.LitemallUserFormid;

public interface LitemallUserFormIdService {
    /**
     * 查找是否有可用的FormId
     *
     * @param openId
     * @return
     */
    LitemallUserFormid queryByOpenId(String openId);

    /**
     * 更新或删除FormId
     *
     * @param userFormid
     */
    int updateUserFormId(LitemallUserFormid userFormid);
    /**
     * 添加一个 FormId
     *
     * @param userFormid
     */
    void addUserFormid(LitemallUserFormid userFormid);
}
