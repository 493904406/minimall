package com.minimall.db.dao;

import com.minimall.db.domain.LitemallGroupon;
import com.minimall.db.domain.LitemallGrouponExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LitemallGrouponMapper {
    long countByExample(LitemallGrouponExample example);

    int deleteByExample(LitemallGrouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGroupon record);

    int insertSelective(LitemallGroupon record);

    LitemallGroupon selectOneByExample(LitemallGrouponExample example);

    LitemallGroupon selectOneByExampleSelective(@Param("example") LitemallGrouponExample example, @Param("selective") LitemallGroupon.Column ... selective);

    List<LitemallGroupon> selectByExampleSelective(@Param("example") LitemallGrouponExample example, @Param("selective") LitemallGroupon.Column ... selective);

    List<LitemallGroupon> selectByExample(LitemallGrouponExample example);

    LitemallGroupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallGroupon.Column ... selective);

    LitemallGroupon selectByPrimaryKey(Integer id);

    LitemallGroupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallGroupon record, @Param("example") LitemallGrouponExample example);

    int updateByExample(@Param("record") LitemallGroupon record, @Param("example") LitemallGrouponExample example);

    int updateByPrimaryKeySelective(LitemallGroupon record);

    int updateByPrimaryKey(LitemallGroupon record);

    int logicalDeleteByExample(@Param("example") LitemallGrouponExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
