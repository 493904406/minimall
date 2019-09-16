package com.minimall.base.service;

import com.github.pagehelper.Page;
import com.minimall.base.domain.dto.GrouponRuleVo;
import com.minimall.db.domain.LitemallGoods;
import com.minimall.db.domain.LitemallGrouponRules;
import com.minimall.db.service.LitemallGoodsService;
import com.minimall.db.service.LitemallGrouponRulesService;
import com.minimall.db.service.LitemallGrouponService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
