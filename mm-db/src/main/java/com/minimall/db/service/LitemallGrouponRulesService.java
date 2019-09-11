package com.minimall.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.minimall.db.dao.LitemallGoodsMapper;
import com.minimall.db.dao.LitemallGrouponRulesMapper;
import com.minimall.db.domain.LitemallGoods;
import com.minimall.db.domain.LitemallGrouponRules;
import com.minimall.db.domain.LitemallGrouponRulesExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class LitemallGrouponRulesService {
    @Resource
    private LitemallGrouponRulesMapper mapper;
    @Resource
    private LitemallGoodsMapper goodsMapper;
    private LitemallGoods.Column[] goodsColumns = new LitemallGoods.Column[]{LitemallGoods.Column.id, LitemallGoods.Column.name, LitemallGoods.Column.brief, LitemallGoods.Column.picUrl, LitemallGoods.Column.counterPrice, LitemallGoods.Column.retailPrice};

    public int createRules(LitemallGrouponRules rules) {
        rules.setAddTime(new Date());
        rules.setUpdateTime(new Date());
        return mapper.insertSelective(rules);
    }

    /**
     * 根据ID查找对应团购项
     *
     * @param id
     * @return
     */
    public LitemallGrouponRules queryById(Integer id) {
        LitemallGrouponRulesExample example = new LitemallGrouponRulesExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 查询某个商品关联的团购规则
     *
     * @param goodsId
     * @return
     */
    public List<LitemallGrouponRules> queryByGoodsId(Integer goodsId) {
        LitemallGrouponRulesExample example = new LitemallGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    /**
     * 获取首页团购活动列表
     *
     * @param page
     * @param limit
     * @return
     */
    public List<LitemallGrouponRules> queryList(Integer page, Integer limit) {
        return queryList(page, limit, "add_time", "desc");
    }

    public List<LitemallGrouponRules> queryList(Integer page, Integer limit, String sort, String order) {
        LitemallGrouponRulesExample example = new LitemallGrouponRulesExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 判断某个团购活动是否已经过期
     *
     * @return
     */
    public boolean isExpired(LitemallGrouponRules rules) {
        return (rules == null || rules.getExpireTime().before(new Date()));
    }

    /**
     * 获取团购活动列表
     *
     * @param goodsId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    public List<LitemallGrouponRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        LitemallGrouponRulesExample example = new LitemallGrouponRulesExample();
        example.setOrderByClause(sort + " " + order);

        LitemallGrouponRulesExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public void delete(Integer id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }

    public int updateById(LitemallGrouponRules grouponRules) {
        grouponRules.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(grouponRules);
    }
}
