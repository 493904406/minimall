package com.minimall.base.service.impl;

import com.github.pagehelper.Page;
import com.minimall.base.domain.dto.GrouponRuleVo;
import com.minimall.base.service.WxGrouponRuleService;
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
@Service
public class WxGrouponRuleServiceImpl implements WxGrouponRuleService {
    private final Log logger = LogFactory.getLog(WxGrouponRuleServiceImpl.class);

    @Autowired
    private LitemallGrouponRulesService grouponRulesService;
    @Autowired
    private LitemallGrouponService grouponService;
    @Autowired
    private LitemallGoodsService goodsService;


    @Override
    public List<GrouponRuleVo> queryList(Integer page, Integer size) {
        return queryList(page, size, "add_time", "desc");
    }


    @Override
    public List<GrouponRuleVo> queryList(Integer page, Integer size, String sort, String order) {
        Page<LitemallGrouponRules> grouponRulesList = (Page)grouponRulesService.queryList(page, size, sort, order);

        Page<GrouponRuleVo> grouponList = new Page<GrouponRuleVo>();
        grouponList.setPages(grouponRulesList.getPages());
        grouponList.setPageNum(grouponRulesList.getPageNum());
        grouponList.setPageSize(grouponRulesList.getPageSize());
        grouponList.setTotal(grouponRulesList.getTotal());

        for (LitemallGrouponRules rule : grouponRulesList) {
            Integer goodsId = rule.getGoodsId();
            LitemallGoods goods = goodsService.findById(goodsId);
            if (goods == null)
                continue;

            GrouponRuleVo grouponRuleVo = new GrouponRuleVo();
            grouponRuleVo.setId(goods.getId());
            grouponRuleVo.setName(goods.getName());
            grouponRuleVo.setBrief(goods.getBrief());
            grouponRuleVo.setPicUrl(goods.getPicUrl());
            grouponRuleVo.setCounterPrice(goods.getCounterPrice());
            grouponRuleVo.setRetailPrice(goods.getRetailPrice());
            grouponRuleVo.setGrouponPrice(goods.getRetailPrice().subtract(rule.getDiscount()));
            grouponRuleVo.setGrouponDiscount(rule.getDiscount());
            grouponRuleVo.setGrouponMember(rule.getDiscountMember());
            grouponList.add(grouponRuleVo);
        }

        return grouponList;
    }
}
