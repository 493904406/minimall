package com.minimall.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.minimall.base.domain.entity.LitemallCategory;
import com.minimall.base.domain.entity.LitemallCategoryExample;
import com.minimall.base.mapper.LitemallCategoryMapper;
import com.minimall.base.service.LitemallCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Date;
import java.util.List;

@Service
public class LitemallCategoryServiceImpl implements LitemallCategoryService {
    @Autowired
    private LitemallCategoryMapper categoryMapper;
    private LitemallCategory.Column[] CHANNEL = {LitemallCategory.Column.id, LitemallCategory.Column.name, LitemallCategory.Column.iconUrl};

    @Override
    public List<LitemallCategory> queryL1WithoutRecommend(int offset, int limit) {
        LitemallCategoryExample example = new LitemallCategoryExample();
        example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<LitemallCategory> queryL1(int offset, int limit) {
        LitemallCategoryExample example = new LitemallCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<LitemallCategory> queryL1() {
        LitemallCategoryExample example = new LitemallCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<LitemallCategory> queryByPid(Integer pid) {
        LitemallCategoryExample example = new LitemallCategoryExample();
        example.or().andPidEqualTo(pid).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<LitemallCategory> queryL2ByIds(List<Integer> ids) {
        LitemallCategoryExample example = new LitemallCategoryExample();
        example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public LitemallCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<LitemallCategory> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        LitemallCategoryExample example = new LitemallCategoryExample();
        LitemallCategoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public int updateById(LitemallCategory category) {
        category.setUpdateTime(new Date());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryMapper.logicalDeleteByPrimaryKey(id);
    }

    @Override
    public void add(LitemallCategory category) {
        category.setAddTime(new Date());
        category.setUpdateTime(new Date());
        categoryMapper.insertSelective(category);
    }

    @Override
    public List<LitemallCategory> queryChannel() {
        LitemallCategoryExample example = new LitemallCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExampleSelective(example, CHANNEL);
    }
}
