package com.minimall.base.service;

import com.minimall.base.domain.entity.LitemallCategory;
import java.util.List;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/10
 * @mail yxb_825@163.com
 */
public interface LitemallCategoryService {

    List<LitemallCategory> queryL1WithoutRecommend(int offset, int limit);

    List<LitemallCategory> queryL1(int offset, int limit);

    List<LitemallCategory> queryL1();

    List<LitemallCategory> queryByPid(Integer pid);

    List<LitemallCategory> queryL2ByIds(List<Integer> ids);

    LitemallCategory findById(Integer id);

    List<LitemallCategory> querySelective(String id, String name, Integer page, Integer size, String sort, String order);

    int updateById(LitemallCategory category);

    void deleteById(Integer id);

    void add(LitemallCategory category);

    List<LitemallCategory> queryChannel();
}
