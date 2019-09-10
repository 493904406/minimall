package com.minimall.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.minimall.base.domain.entity.LitemallBrand;
import com.minimall.base.domain.entity.LitemallBrand.Column;
import com.minimall.base.domain.entity.LitemallBrandExample;
import com.minimall.base.mapper.LitemallBrandMapper;
import com.minimall.base.service.LitemallBrandService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/10
 * @mail yxb_825@163.com
 */
@Service
public class LitemallBrandServiceImpl implements LitemallBrandService {
    @Resource
    private LitemallBrandMapper brandMapper;
    private Column[] columns = new Column[]{Column.id, Column.name, Column.desc, Column.picUrl, Column.floorPrice};

    @Override
    public List<LitemallBrand> query(Integer page, Integer limit, String sort, String order) {
        LitemallBrandExample example = new LitemallBrandExample();
        example.or().andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, limit);
        return brandMapper.selectByExampleSelective(example, columns);
    }

    @Override
    public List<LitemallBrand> query(Integer page, Integer limit) {
        return query(page, limit, null, null);
    }

    @Override
    public LitemallBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<LitemallBrand> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        LitemallBrandExample example = new LitemallBrandExample();
        LitemallBrandExample.Criteria criteria = example.createCriteria();

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
        return brandMapper.selectByExample(example);
    }

    @Override
    public int updateById(LitemallBrand brand) {
        brand.setUpdateTime(new Date());
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void deleteById(Integer id) {
        brandMapper.logicalDeleteByPrimaryKey(id);
    }

    @Override
    public void add(LitemallBrand brand) {
        brand.setAddTime(new Date());
        brand.setUpdateTime(new Date());
        brandMapper.insertSelective(brand);
    }

    @Override
    public List<LitemallBrand> all() {
        LitemallBrandExample example = new LitemallBrandExample();
        example.or().andDeletedEqualTo(false);
        return brandMapper.selectByExample(example);
    }
}
