package com.minimall.user.dao.mapper;

import com.minimall.user.domain.entity.LitemallCart;
import com.minimall.user.domain.entity.LitemallCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LitemallCartMapper {
    long countByExample(LitemallCartExample example);

    int deleteByExample(LitemallCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCart record);

    int insertSelective(LitemallCart record);

    LitemallCart selectOneByExample(LitemallCartExample example);

    LitemallCart selectOneByExampleSelective(@Param("example") LitemallCartExample example, @Param("selective") LitemallCart.Column ... selective);

    List<LitemallCart> selectByExampleSelective(@Param("example") LitemallCartExample example, @Param("selective") LitemallCart.Column ... selective);

    List<LitemallCart> selectByExample(LitemallCartExample example);

    LitemallCart selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallCart.Column ... selective);

    LitemallCart selectByPrimaryKey(Integer id);

    LitemallCart selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallCart record, @Param("example") LitemallCartExample example);

    int updateByExample(@Param("record") LitemallCart record, @Param("example") LitemallCartExample example);

    int updateByPrimaryKeySelective(LitemallCart record);

    int updateByPrimaryKey(LitemallCart record);

    int logicalDeleteByExample(@Param("example") LitemallCartExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}