package com.minimall.user.dao.mapper;

import com.minimall.user.domain.entity.LitemallAddress;
import com.minimall.user.domain.entity.LitemallAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LitemallAddressMapper {
    long countByExample(LitemallAddressExample example);

    int deleteByExample(LitemallAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAddress record);

    int insertSelective(LitemallAddress record);

    LitemallAddress selectOneByExample(LitemallAddressExample example);

    LitemallAddress selectOneByExampleSelective(@Param("example") LitemallAddressExample example, @Param("selective") LitemallAddress.Column ... selective);

    List<LitemallAddress> selectByExampleSelective(@Param("example") LitemallAddressExample example, @Param("selective") LitemallAddress.Column ... selective);

    List<LitemallAddress> selectByExample(LitemallAddressExample example);

    LitemallAddress selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallAddress.Column ... selective);

    LitemallAddress selectByPrimaryKey(Integer id);

    LitemallAddress selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallAddress record, @Param("example") LitemallAddressExample example);

    int updateByExample(@Param("record") LitemallAddress record, @Param("example") LitemallAddressExample example);

    int updateByPrimaryKeySelective(LitemallAddress record);

    int updateByPrimaryKey(LitemallAddress record);

    int logicalDeleteByExample(@Param("example") LitemallAddressExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}