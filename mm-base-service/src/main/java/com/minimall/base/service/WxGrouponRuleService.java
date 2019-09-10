package com.minimall.base.service;

import com.minimall.base.domain.dto.GrouponRuleVo;
import java.util.List;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/10
 * @mail yxb_825@163.com
 */
public interface WxGrouponRuleService {


    List<GrouponRuleVo> queryList(Integer page, Integer size);


    List<GrouponRuleVo> queryList(Integer page, Integer size, String sort, String order);
}
