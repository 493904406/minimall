package com.minimall.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.minimall.db.dao.LitemallRoleMapper;
import com.minimall.db.domain.LitemallRole;
import com.minimall.db.domain.LitemallRoleExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

@Service
public class LitemallRoleService {
    @Resource
    private LitemallRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if(roleIds.length == 0){
            return roles;
        }

        LitemallRoleExample example = new LitemallRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<LitemallRole> roleList = roleMapper.selectByExample(example);

        for(LitemallRole role : roleList){
            roles.add(role.getName());
        }

        return roles;

    }

    public List<LitemallRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        LitemallRoleExample example = new LitemallRoleExample();
        LitemallRoleExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return roleMapper.selectByExample(example);
    }

    public LitemallRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(LitemallRole role) {
        role.setAddTime(new Date());
        role.setUpdateTime(new Date());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(LitemallRole role) {
        role.setUpdateTime(new Date());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        LitemallRoleExample example = new LitemallRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<LitemallRole> queryAll() {
        LitemallRoleExample example = new LitemallRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
