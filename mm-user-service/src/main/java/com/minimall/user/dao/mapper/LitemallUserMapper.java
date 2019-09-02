package com.minimall.user.dao.mapper;

import com.minimall.user.domain.entity.LitemallUser;
import com.minimall.user.domain.entity.LitemallUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LitemallUserMapper {
    long countByExample(LitemallUserExample example);

    int deleteByExample(LitemallUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallUser record);

    int insertSelective(LitemallUser record);

    LitemallUser selectOneByExample(LitemallUserExample example);

    LitemallUser selectOneByExampleSelective(@Param("example") LitemallUserExample example, @Param("selective") LitemallUser.Column ... selective);

    List<LitemallUser> selectByExampleSelective(@Param("example") LitemallUserExample example, @Param("selective") LitemallUser.Column ... selective);

    List<LitemallUser> selectByExample(LitemallUserExample example);

    LitemallUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallUser.Column ... selective);

    LitemallUser selectByPrimaryKey(Integer id);

    LitemallUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallUser record, @Param("example") LitemallUserExample example);

    int updateByExample(@Param("record") LitemallUser record, @Param("example") LitemallUserExample example);

    int updateByPrimaryKeySelective(LitemallUser record);

    int updateByPrimaryKey(LitemallUser record);

    int logicalDeleteByExample(@Param("example") LitemallUserExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}