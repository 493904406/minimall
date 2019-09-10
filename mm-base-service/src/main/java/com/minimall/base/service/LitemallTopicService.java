package com.minimall.base.service;


import com.minimall.base.domain.entity.LitemallTopic;
import java.util.List;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/10
 * @mail yxb_825@163.com
 */
public interface LitemallTopicService {

    List<LitemallTopic> queryList(int offset, int limit);

    List<LitemallTopic> queryList(int offset, int limit, String sort, String order);

    int queryTotal();

    LitemallTopic findById(Integer id);

    List<LitemallTopic> queryRelatedList(Integer id, int offset, int limit);

    List<LitemallTopic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order);

    int updateById(LitemallTopic topic);

    void deleteById(Integer id);

    void add(LitemallTopic topic);


}
