package com.minimall.db.service;

import com.github.pagehelper.PageHelper;

import com.minimall.db.dao.LitemallFeedbackMapper;
import com.minimall.db.domain.LitemallFeedback;
import com.minimall.db.domain.LitemallFeedbackExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;


@Service
public class LitemallFeedbackService {
    @Autowired
    private LitemallFeedbackMapper feedbackMapper;

    public Integer add(LitemallFeedback feedback) {
        feedback.setAddTime(new Date());
        feedback.setUpdateTime(new Date());
        return feedbackMapper.insertSelective(feedback);
    }

    public List<LitemallFeedback> querySelective(Integer userId, String username, Integer page, Integer limit, String sort, String order) {
        LitemallFeedbackExample example = new LitemallFeedbackExample();
        LitemallFeedbackExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return feedbackMapper.selectByExample(example);
    }
}
