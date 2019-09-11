package com.minimall.db.dao;

import com.minimall.db.domain.LitemallOrderGoods;
import com.minimall.db.domain.LitemallOrderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LitemallOrderGoodsMapper {
    long countByExample(LitemallOrderGoodsExample example);

    int deleteByExample(LitemallOrderGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallOrderGoods record);

    int insertSelective(LitemallOrderGoods record);

    LitemallOrderGoods selectOneByExample(LitemallOrderGoodsExample example);

    LitemallOrderGoods selectOneByExampleSelective(@Param("example") LitemallOrderGoodsExample example, @Param("selective") LitemallOrderGoods.Column ... selective);

    List<LitemallOrderGoods> selectByExampleSelective(@Param("example") LitemallOrderGoodsExample example, @Param("selective") LitemallOrderGoods.Column ... selective);

    List<LitemallOrderGoods> selectByExample(LitemallOrderGoodsExample example);

    LitemallOrderGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallOrderGoods.Column ... selective);

    LitemallOrderGoods selectByPrimaryKey(Integer id);

    LitemallOrderGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallOrderGoods record, @Param("example") LitemallOrderGoodsExample example);

    int updateByExample(@Param("record") LitemallOrderGoods record, @Param("example") LitemallOrderGoodsExample example);

    int updateByPrimaryKeySelective(LitemallOrderGoods record);

    int updateByPrimaryKey(LitemallOrderGoods record);

    int logicalDeleteByExample(@Param("example") LitemallOrderGoodsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
