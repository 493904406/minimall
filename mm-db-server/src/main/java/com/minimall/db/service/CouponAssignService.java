package com.minimall.db.service;

import com.minimall.common.utils.DateUtil;
import com.minimall.db.domain.LitemallCoupon;
import com.minimall.db.domain.LitemallCouponUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class CouponAssignService {

    @Autowired
    private LitemallCouponUserService couponUserService;
    @Autowired
    private LitemallCouponService couponService;

    /**
     * 分发注册优惠券
     *
     * @param userId
     * @return
     */
    public void assignForRegister(Integer userId) {
        List<LitemallCoupon> couponList = couponService.queryRegister();
        for(LitemallCoupon coupon : couponList){
            Integer couponId = coupon.getId();

            Integer count = couponUserService.countUserAndCoupon(userId, couponId);
            if (count > 0) {
                continue;
            }

            Short limit = coupon.getLimit();
            while(limit > 0){
                LitemallCouponUser couponUser = new LitemallCouponUser();
                couponUser.setCouponId(couponId);
                couponUser.setUserId(userId);
                Short timeType = coupon.getTimeType();
                if (timeType.equals(org.linlinjava.litemall.db.util.CouponConstant.TIME_TYPE_TIME)) {
                    couponUser.setStartTime(coupon.getStartTime());
                    couponUser.setEndTime(coupon.getEndTime());
                }
                else{
                    Date now = new Date();
                    couponUser.setStartTime(now);
                    couponUser.setEndTime(DateUtil.addDays(now,coupon.getDays()));
                }
                couponUserService.add(couponUser);

                limit--;
            }
        }

    }

}
