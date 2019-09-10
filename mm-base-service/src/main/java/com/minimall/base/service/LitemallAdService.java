package com.minimall.base.service;

import com.minimall.base.domain.entity.LitemallAd;

import java.util.List;
/**
 * @author yanxubin
 * @Description
 * @date:2019/9/10
 * @mail yxb_825@163.com
 */
public interface LitemallAdService {

    List<LitemallAd> queryIndex();

    List<LitemallAd> querySelective(String name, String content, Integer page, Integer limit, String sort, String order);

    int updateById(LitemallAd ad);

    void deleteById(Integer id);

    void add(LitemallAd ad);

    LitemallAd findById(Integer id);
}
