package com.minimall.db.dao;

import com.minimall.db.domain.LitemallIssue;
import com.minimall.db.domain.LitemallIssueExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LitemallIssueMapper {
    long countByExample(LitemallIssueExample example);

    int deleteByExample(LitemallIssueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallIssue record);

    int insertSelective(LitemallIssue record);

    LitemallIssue selectOneByExample(LitemallIssueExample example);

    LitemallIssue selectOneByExampleSelective(@Param("example") LitemallIssueExample example, @Param("selective") LitemallIssue.Column ... selective);

    List<LitemallIssue> selectByExampleSelective(@Param("example") LitemallIssueExample example, @Param("selective") LitemallIssue.Column ... selective);

    List<LitemallIssue> selectByExample(LitemallIssueExample example);

    LitemallIssue selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallIssue.Column ... selective);

    LitemallIssue selectByPrimaryKey(Integer id);

    LitemallIssue selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallIssue record, @Param("example") LitemallIssueExample example);

    int updateByExample(@Param("record") LitemallIssue record, @Param("example") LitemallIssueExample example);

    int updateByPrimaryKeySelective(LitemallIssue record);

    int updateByPrimaryKey(LitemallIssue record);

    int logicalDeleteByExample(@Param("example") LitemallIssueExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
