package com.minimall.db.dao;

import com.minimall.db.domain.LitemallBrand;
import com.minimall.db.domain.LitemallBrandExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LitemallBrandMapper {
    long countByExample(LitemallBrandExample example);

    int deleteByExample(LitemallBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallBrand record);

    int insertSelective(LitemallBrand record);

    LitemallBrand selectOneByExample(LitemallBrandExample example);

    LitemallBrand selectOneByExampleSelective(@Param("example") LitemallBrandExample example, @Param("selective") LitemallBrand.Column ... selective);

    List<LitemallBrand> selectByExampleSelective(@Param("example") LitemallBrandExample example, @Param("selective") LitemallBrand.Column ... selective);

    List<LitemallBrand> selectByExample(LitemallBrandExample example);

    LitemallBrand selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallBrand.Column ... selective);

    LitemallBrand selectByPrimaryKey(Integer id);

    LitemallBrand selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallBrand record, @Param("example") LitemallBrandExample example);

    int updateByExample(@Param("record") LitemallBrand record, @Param("example") LitemallBrandExample example);

    int updateByPrimaryKeySelective(LitemallBrand record);

    int updateByPrimaryKey(LitemallBrand record);

    int logicalDeleteByExample(@Param("example") LitemallBrandExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
