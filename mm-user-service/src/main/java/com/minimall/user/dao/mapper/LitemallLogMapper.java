package com.minimall.user.dao.mapper;

import com.minimall.user.domain.entity.LitemallLog;
import com.minimall.user.domain.entity.LitemallLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LitemallLogMapper {
    long countByExample(LitemallLogExample example);

    int deleteByExample(LitemallLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallLog record);

    int insertSelective(LitemallLog record);

    LitemallLog selectOneByExample(LitemallLogExample example);

    LitemallLog selectOneByExampleSelective(@Param("example") LitemallLogExample example, @Param("selective") LitemallLog.Column ... selective);

    List<LitemallLog> selectByExampleSelective(@Param("example") LitemallLogExample example, @Param("selective") LitemallLog.Column ... selective);

    List<LitemallLog> selectByExample(LitemallLogExample example);

    LitemallLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallLog.Column ... selective);

    LitemallLog selectByPrimaryKey(Integer id);

    LitemallLog selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallLog record, @Param("example") LitemallLogExample example);

    int updateByExample(@Param("record") LitemallLog record, @Param("example") LitemallLogExample example);

    int updateByPrimaryKeySelective(LitemallLog record);

    int updateByPrimaryKey(LitemallLog record);

    int logicalDeleteByExample(@Param("example") LitemallLogExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}