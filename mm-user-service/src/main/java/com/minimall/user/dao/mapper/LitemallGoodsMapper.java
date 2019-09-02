package com.minimall.user.dao.mapper;

import com.minimall.user.domain.entity.LitemallGoods;
import com.minimall.user.domain.entity.LitemallGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LitemallGoodsMapper {
    long countByExample(LitemallGoodsExample example);

    int deleteByExample(LitemallGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGoods record);

    int insertSelective(LitemallGoods record);

    LitemallGoods selectOneByExample(LitemallGoodsExample example);

    LitemallGoods selectOneByExampleSelective(@Param("example") LitemallGoodsExample example, @Param("selective") LitemallGoods.Column ... selective);

    LitemallGoods selectOneByExampleWithBLOBs(LitemallGoodsExample example);

    List<LitemallGoods> selectByExampleSelective(@Param("example") LitemallGoodsExample example, @Param("selective") LitemallGoods.Column ... selective);

    List<LitemallGoods> selectByExampleWithBLOBs(LitemallGoodsExample example);

    List<LitemallGoods> selectByExample(LitemallGoodsExample example);

    LitemallGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallGoods.Column ... selective);

    LitemallGoods selectByPrimaryKey(Integer id);

    LitemallGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallGoods record, @Param("example") LitemallGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") LitemallGoods record, @Param("example") LitemallGoodsExample example);

    int updateByExample(@Param("record") LitemallGoods record, @Param("example") LitemallGoodsExample example);

    int updateByPrimaryKeySelective(LitemallGoods record);

    int updateByPrimaryKeyWithBLOBs(LitemallGoods record);

    int updateByPrimaryKey(LitemallGoods record);

    int logicalDeleteByExample(@Param("example") LitemallGoodsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}