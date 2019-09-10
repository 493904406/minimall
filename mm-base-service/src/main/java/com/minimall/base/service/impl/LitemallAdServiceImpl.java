package com.minimall.base.service.impl;
import com.github.pagehelper.PageHelper;
import com.minimall.base.domain.entity.LitemallAd;
import com.minimall.base.domain.entity.LitemallAdExample;
import com.minimall.base.mapper.LitemallAdMapper;
import com.minimall.base.service.LitemallAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Date;
import java.util.List;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/10
 * @mail yxb_825@163.com
 */
@Service
public class LitemallAdServiceImpl implements LitemallAdService {
    @Autowired
    private LitemallAdMapper adMapper;

    @Override
    public List<LitemallAd> queryIndex() {
        LitemallAdExample example = new LitemallAdExample();
        example.or().andPositionEqualTo((byte) 1).andDeletedEqualTo(false).andEnabledEqualTo(true);
        return adMapper.selectByExample(example);
    }

    @Override
    public List<LitemallAd> querySelective(String name, String content, Integer page, Integer limit, String sort, String order) {
        LitemallAdExample example = new LitemallAdExample();
        LitemallAdExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(content)) {
            criteria.andContentLike("%" + content + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return adMapper.selectByExample(example);
    }

    @Override
    public int updateById(LitemallAd ad) {
        ad.setUpdateTime(new Date());
        return adMapper.updateByPrimaryKeySelective(ad);
    }

    @Override
    public void deleteById(Integer id) {
        adMapper.logicalDeleteByPrimaryKey(id);
    }

    @Override
    public void add(LitemallAd ad) {
        ad.setAddTime(new Date());
        ad.setUpdateTime(new Date());
        adMapper.insertSelective(ad);
    }

    @Override
    public LitemallAd findById(Integer id) {
        return adMapper.selectByPrimaryKey(id);
    }
}
