package com.minimall.base.mapper;

import com.minimall.base.domain.entity.LitemallCategory;
import com.minimall.base.domain.entity.LitemallCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LitemallCategoryMapper {
    long countByExample(LitemallCategoryExample example);

    int deleteByExample(LitemallCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCategory record);

    int insertSelective(LitemallCategory record);

    LitemallCategory selectOneByExample(LitemallCategoryExample example);

    LitemallCategory selectOneByExampleSelective(@Param("example") LitemallCategoryExample example, @Param("selective") LitemallCategory.Column ... selective);

    List<LitemallCategory> selectByExampleSelective(@Param("example") LitemallCategoryExample example, @Param("selective") LitemallCategory.Column ... selective);

    List<LitemallCategory> selectByExample(LitemallCategoryExample example);

    LitemallCategory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallCategory.Column ... selective);

    LitemallCategory selectByPrimaryKey(Integer id);

    LitemallCategory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallCategory record, @Param("example") LitemallCategoryExample example);

    int updateByExample(@Param("record") LitemallCategory record, @Param("example") LitemallCategoryExample example);

    int updateByPrimaryKeySelective(LitemallCategory record);

    int updateByPrimaryKey(LitemallCategory record);

    int logicalDeleteByExample(@Param("example") LitemallCategoryExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
