package com.minimall.db.dao;

import com.minimall.db.domain.LitemallRegion;
import com.minimall.db.domain.LitemallRegionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LitemallRegionMapper {
    long countByExample(LitemallRegionExample example);

    int deleteByExample(LitemallRegionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallRegion record);

    int insertSelective(LitemallRegion record);

    LitemallRegion selectOneByExample(LitemallRegionExample example);

    LitemallRegion selectOneByExampleSelective(@Param("example") LitemallRegionExample example, @Param("selective") LitemallRegion.Column ... selective);

    List<LitemallRegion> selectByExampleSelective(@Param("example") LitemallRegionExample example, @Param("selective") LitemallRegion.Column ... selective);

    List<LitemallRegion> selectByExample(LitemallRegionExample example);

    LitemallRegion selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallRegion.Column ... selective);

    LitemallRegion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LitemallRegion record, @Param("example") LitemallRegionExample example);

    int updateByExample(@Param("record") LitemallRegion record, @Param("example") LitemallRegionExample example);

    int updateByPrimaryKeySelective(LitemallRegion record);

    int updateByPrimaryKey(LitemallRegion record);
}
