package com.minimall.message.service.impl;


import com.minimall.message.mapper.LitemallUserFormidMapper;
import com.minimall.message.domain.entity.LitemallUserFormid;
import com.minimall.message.domain.entity.LitemallUserFormidExample;
import com.minimall.message.service.LitemallUserFormIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/2
 * @mail yxb_825@163.com
 */
@Service
public class LitemallUserFormIdServiceImpl implements LitemallUserFormIdService {
    @Autowired
    private LitemallUserFormidMapper formidMapper;

    /**
     * 查找是否有可用的FormId
     *
     * @param openId
     * @return
     */
    @Override
    public LitemallUserFormid queryByOpenId(String openId) {
        LitemallUserFormidExample example = new LitemallUserFormidExample();
        //符合找到该用户记录，且可用次数大于1，且还未过期
        example.or().andOpenidEqualTo(openId).andExpireTimeGreaterThan(new Date());
        return formidMapper.selectOneByExample(example);
    }

    /**
     * 更新或删除FormId
     *
     * @param userFormid
     */
    @Override
    public int updateUserFormId(LitemallUserFormid userFormid) {
        //更新或者删除缓存
        if (userFormid.getIsprepay() && userFormid.getUseamount() > 1) {
            userFormid.setUseamount(userFormid.getUseamount() - 1);
            userFormid.setUpdateTime(new Date());
            return formidMapper.updateByPrimaryKey(userFormid);
        } else {
            return formidMapper.deleteByPrimaryKey(userFormid.getId());
        }
    }

    /**
     * 添加一个 FormId
     *
     * @param userFormid
     */
    @Override
    public void addUserFormid(LitemallUserFormid userFormid) {
        userFormid.setAddTime(new Date());
        userFormid.setUpdateTime(new Date());
        formidMapper.insertSelective(userFormid);
    }
}
