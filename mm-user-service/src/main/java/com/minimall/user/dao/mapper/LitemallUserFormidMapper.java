package com.minimall.user.dao.mapper;

import com.minimall.user.domain.entity.LitemallUserFormid;
import com.minimall.user.domain.entity.LitemallUserFormidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LitemallUserFormidMapper {
    long countByExample(LitemallUserFormidExample example);

    int deleteByExample(LitemallUserFormidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallUserFormid record);

    int insertSelective(LitemallUserFormid record);

    LitemallUserFormid selectOneByExample(LitemallUserFormidExample example);

    LitemallUserFormid selectOneByExampleSelective(@Param("example") LitemallUserFormidExample example, @Param("selective") LitemallUserFormid.Column ... selective);

    List<LitemallUserFormid> selectByExampleSelective(@Param("example") LitemallUserFormidExample example, @Param("selective") LitemallUserFormid.Column ... selective);

    List<LitemallUserFormid> selectByExample(LitemallUserFormidExample example);

    LitemallUserFormid selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallUserFormid.Column ... selective);

    LitemallUserFormid selectByPrimaryKey(Integer id);

    LitemallUserFormid selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallUserFormid record, @Param("example") LitemallUserFormidExample example);

    int updateByExample(@Param("record") LitemallUserFormid record, @Param("example") LitemallUserFormidExample example);

    int updateByPrimaryKeySelective(LitemallUserFormid record);

    int updateByPrimaryKey(LitemallUserFormid record);

    int logicalDeleteByExample(@Param("example") LitemallUserFormidExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}