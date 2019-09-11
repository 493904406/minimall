package com.minimall.user.service;


import com.minimall.user.domain.entity.LitemallGoodsAttribute;
import com.minimall.user.domain.entity.LitemallGoodsAttributeExample;
import com.minimall.user.mapper.LitemallGoodsAttributeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class LitemallGoodsAttributeService {
    @Resource
    private LitemallGoodsAttributeMapper goodsAttributeMapper;

    public List<LitemallGoodsAttribute> queryByGid(Integer goodsId) {
        LitemallGoodsAttributeExample example = new LitemallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(LitemallGoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(new Date());
        goodsAttribute.setUpdateTime(new Date());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public LitemallGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        LitemallGoodsAttributeExample example = new LitemallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }
}
