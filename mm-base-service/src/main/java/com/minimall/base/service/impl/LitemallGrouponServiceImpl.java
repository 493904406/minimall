package com.minimall.base.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.minimall.base.domain.entity.LitemallGroupon;
import com.minimall.base.domain.entity.LitemallGrouponExample;
import com.minimall.base.mapper.LitemallGrouponMapper;
import com.minimall.base.service.LitemallGrouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/10
 * @mail yxb_825@163.com
 */
@Service
public class LitemallGrouponServiceImpl implements LitemallGrouponService {
    @Autowired
    private LitemallGrouponMapper mapper;

    /**
     * 获取用户发起的团购记录
     *
     * @param userId
     * @return
     */
    @Override
    public List<LitemallGroupon> queryMyGroupon(Integer userId) {
        LitemallGrouponExample example = new LitemallGrouponExample();
        example.or().andUserIdEqualTo(userId).andCreatorUserIdEqualTo(userId).andGrouponIdEqualTo(0).andDeletedEqualTo(false).andPayedEqualTo(true);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 获取用户参与的团购记录
     *
     * @param userId
     * @return
     */
    @Override
    public List<LitemallGroupon> queryMyJoinGroupon(Integer userId) {
        LitemallGrouponExample example = new LitemallGrouponExample();
        example.or().andUserIdEqualTo(userId).andGrouponIdNotEqualTo(0).andDeletedEqualTo(false).andPayedEqualTo(true);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 根据OrderId查询团购记录
     *
     * @param orderId
     * @return
     */
    @Override
    public LitemallGroupon queryByOrderId(Integer orderId) {
        LitemallGrouponExample example = new LitemallGrouponExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 获取某个团购活动参与的记录
     *
     * @param id
     * @return
     */
    @Override
    public List<LitemallGroupon> queryJoinRecord(Integer id) {
        LitemallGrouponExample example = new LitemallGrouponExample();
        example.or().andGrouponIdEqualTo(id).andDeletedEqualTo(false).andPayedEqualTo(true);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    @Override
    public LitemallGroupon queryById(Integer id) {
        LitemallGrouponExample example = new LitemallGrouponExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false).andPayedEqualTo(true);
        return mapper.selectOneByExample(example);
    }

    /**
     * 返回某个发起的团购参与人数
     *
     * @param grouponId
     * @return
     */
    @Override
    public int countGroupon(Integer grouponId) {
        LitemallGrouponExample example = new LitemallGrouponExample();
        example.or().andGrouponIdEqualTo(grouponId).andDeletedEqualTo(false).andPayedEqualTo(true);
        return (int) mapper.countByExample(example);
    }

    @Override
    public int updateById(LitemallGroupon groupon) {
        groupon.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(groupon);
    }

    /**
     * 创建或参与一个团购
     *
     * @param groupon
     * @return
     */
    @Override
    public int createGroupon(LitemallGroupon groupon) {
        groupon.setAddTime(new Date());
        groupon.setUpdateTime(new Date());
        return mapper.insertSelective(groupon);
    }


    /**
     * 查询所有发起的团购记录
     *
     * @param rulesId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    @Override
    public List<LitemallGroupon> querySelective(String rulesId, Integer page, Integer size, String sort, String order) {
        LitemallGrouponExample example = new LitemallGrouponExample();
        LitemallGrouponExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(rulesId)) {
            criteria.andRulesIdEqualTo(Integer.parseInt(rulesId));
        }
        criteria.andDeletedEqualTo(false);
        criteria.andPayedEqualTo(true);
        criteria.andGrouponIdEqualTo(0);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
}
