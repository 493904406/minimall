package com.minimall.base.mapper;
import com.minimall.base.domain.entity.LitemallAd;
import com.minimall.base.domain.entity.LitemallAdExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LitemallAdMapper {
    long countByExample(LitemallAdExample example);

    int deleteByExample(LitemallAdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAd record);

    int insertSelective(LitemallAd record);

    LitemallAd selectOneByExample(LitemallAdExample example);

    LitemallAd selectOneByExampleSelective(@Param("example") LitemallAdExample example, @Param("selective") LitemallAd.Column ... selective);

    List<LitemallAd> selectByExampleSelective(@Param("example") LitemallAdExample example, @Param("selective") LitemallAd.Column ... selective);

    List<LitemallAd> selectByExample(LitemallAdExample example);

    LitemallAd selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallAd.Column ... selective);

    LitemallAd selectByPrimaryKey(Integer id);

    LitemallAd selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallAd record, @Param("example") LitemallAdExample example);

    int updateByExample(@Param("record") LitemallAd record, @Param("example") LitemallAdExample example);

    int updateByPrimaryKeySelective(LitemallAd record);

    int updateByPrimaryKey(LitemallAd record);

    int logicalDeleteByExample(@Param("example") LitemallAdExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
