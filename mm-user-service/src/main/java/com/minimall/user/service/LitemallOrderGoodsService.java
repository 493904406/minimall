package com.minimall.user.service;


import com.minimall.user.domain.entity.LitemallOrderGoods;
import com.minimall.user.domain.entity.LitemallOrderGoodsExample;
import com.minimall.user.mapper.LitemallOrderGoodsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class LitemallOrderGoodsService {
    @Resource
    private LitemallOrderGoodsMapper orderGoodsMapper;

    public int add(LitemallOrderGoods orderGoods) {
        orderGoods.setAddTime(new Date());
        orderGoods.setUpdateTime(new Date());
        return orderGoodsMapper.insertSelective(orderGoods);
    }

    public List<LitemallOrderGoods> queryByOid(Integer orderId) {
        LitemallOrderGoodsExample example = new LitemallOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public List<LitemallOrderGoods> findByOidAndGid(Integer orderId, Integer goodsId) {
        LitemallOrderGoodsExample example = new LitemallOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public LitemallOrderGoods findById(Integer id) {
        return orderGoodsMapper.selectByPrimaryKey(id);
    }

    public void updateById(LitemallOrderGoods orderGoods) {
        orderGoods.setUpdateTime(new Date());
        orderGoodsMapper.updateByPrimaryKeySelective(orderGoods);
    }

    public Short getComments(Integer orderId) {
        LitemallOrderGoodsExample example = new LitemallOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        long count = orderGoodsMapper.countByExample(example);
        return (short) count;
    }

    public boolean checkExist(Integer goodsId) {
        LitemallOrderGoodsExample example = new LitemallOrderGoodsExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.countByExample(example) != 0;
    }
}
