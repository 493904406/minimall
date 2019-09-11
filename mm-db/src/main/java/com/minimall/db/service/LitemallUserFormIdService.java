package com.minimall.db.service;


import com.minimall.db.dao.LitemallUserFormidMapper;
import com.minimall.db.domain.LitemallUserFormid;
import com.minimall.db.domain.LitemallUserFormidExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class LitemallUserFormIdService {
    @Resource
    private LitemallUserFormidMapper formidMapper;

    /**
     * 查找是否有可用的FormId
     *
     * @param openId
     * @return
     */
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
    public void addUserFormid(LitemallUserFormid userFormid) {
        userFormid.setAddTime(new Date());
        userFormid.setUpdateTime(new Date());
        formidMapper.insertSelective(userFormid);
    }
}
