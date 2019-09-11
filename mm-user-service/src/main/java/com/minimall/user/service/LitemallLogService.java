package com.minimall.user.service;

import com.github.pagehelper.PageHelper;
import com.minimall.user.domain.entity.LitemallLog;
import com.minimall.user.domain.entity.LitemallLogExample;
import com.minimall.user.mapper.LitemallLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class LitemallLogService {
    @Resource
    private LitemallLogMapper logMapper;

    public void deleteById(Integer id) {
        logMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LitemallLog log) {
        log.setAddTime(new Date());
        log.setUpdateTime(new Date());
        logMapper.insertSelective(log);
    }

    public List<LitemallLog> querySelective(String name, Integer page, Integer size, String sort, String order) {
        LitemallLogExample example = new LitemallLogExample();
        LitemallLogExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andAdminLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return logMapper.selectByExample(example);
    }
}
