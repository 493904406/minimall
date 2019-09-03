package com.minimall.user.mapper;

import com.minimall.user.domain.entity.LitemallCoupon;
import com.minimall.user.domain.entity.LitemallCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LitemallCouponMapper {
    long countByExample(LitemallCouponExample example);

    int deleteByExample(LitemallCouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCoupon record);

    int insertSelective(LitemallCoupon record);

    LitemallCoupon selectOneByExample(LitemallCouponExample example);

    LitemallCoupon selectOneByExampleSelective(@Param("example") LitemallCouponExample example, @Param("selective") LitemallCoupon.Column ... selective);

    List<LitemallCoupon> selectByExampleSelective(@Param("example") LitemallCouponExample example, @Param("selective") LitemallCoupon.Column ... selective);

    List<LitemallCoupon> selectByExample(LitemallCouponExample example);

    LitemallCoupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallCoupon.Column ... selective);

    LitemallCoupon selectByPrimaryKey(Integer id);

    LitemallCoupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallCoupon record, @Param("example") LitemallCouponExample example);

    int updateByExample(@Param("record") LitemallCoupon record, @Param("example") LitemallCouponExample example);

    int updateByPrimaryKeySelective(LitemallCoupon record);

    int updateByPrimaryKey(LitemallCoupon record);

    int logicalDeleteByExample(@Param("example") LitemallCouponExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}