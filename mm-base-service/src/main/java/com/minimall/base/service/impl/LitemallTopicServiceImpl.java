package com.minimall.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.minimall.base.domain.entity.LitemallTopic;
import com.minimall.base.domain.entity.LitemallTopic.Column;
import com.minimall.base.domain.entity.LitemallTopicExample;
import com.minimall.base.mapper.LitemallTopicMapper;
import com.minimall.base.service.LitemallTopicService;
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
public class LitemallTopicServiceImpl implements LitemallTopicService {
    @Autowired
    private LitemallTopicMapper topicMapper;
    private Column[] columns = new Column[]{Column.id, Column.title, Column.subtitle, Column.price, Column.picUrl, Column.readCount};

    @Override
    public List<LitemallTopic> queryList(int offset, int limit) {
        return queryList(offset, limit, "add_time", "desc");
    }

    @Override
    public List<LitemallTopic> queryList(int offset, int limit, String sort, String order) {
        LitemallTopicExample example = new LitemallTopicExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(offset, limit);
        return topicMapper.selectByExampleSelective(example, columns);
    }

    @Override
    public int queryTotal() {
        LitemallTopicExample example = new LitemallTopicExample();
        example.or().andDeletedEqualTo(false);
        return (int) topicMapper.countByExample(example);
    }

    @Override
    public LitemallTopic findById(Integer id) {
        LitemallTopicExample example = new LitemallTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return topicMapper.selectOneByExampleWithBLOBs(example);
    }

    @Override
    public List<LitemallTopic> queryRelatedList(Integer id, int offset, int limit) {
        LitemallTopicExample example = new LitemallTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        List<LitemallTopic> topics = topicMapper.selectByExample(example);
        if (topics.size() == 0) {
            return queryList(offset, limit, "add_time", "desc");
        }
        LitemallTopic topic = topics.get(0);

        example = new LitemallTopicExample();
        example.or().andIdNotEqualTo(topic.getId()).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        List<LitemallTopic> relateds = topicMapper.selectByExampleWithBLOBs(example);
        if (relateds.size() != 0) {
            return relateds;
        }

        return queryList(offset, limit, "add_time", "desc");
    }

    @Override
    public List<LitemallTopic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order) {
        LitemallTopicExample example = new LitemallTopicExample();
        LitemallTopicExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return topicMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public int updateById(LitemallTopic topic) {
        topic.setUpdateTime(new Date());
        LitemallTopicExample example = new LitemallTopicExample();
        example.or().andIdEqualTo(topic.getId());
        return topicMapper.updateByExampleSelective(topic, example);
    }

    @Override
    public void deleteById(Integer id) {
        topicMapper.logicalDeleteByPrimaryKey(id);
    }

    @Override
    public void add(LitemallTopic topic) {
        topic.setAddTime(new Date());
        topic.setUpdateTime(new Date());
        topicMapper.insertSelective(topic);
    }


}
