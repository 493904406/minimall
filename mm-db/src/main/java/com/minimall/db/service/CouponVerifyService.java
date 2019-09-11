package com.minimall.db.service;

import com.minimall.common.utils.DateTimeUtil;
import com.minimall.common.utils.DateUtil;
import com.minimall.db.domain.LitemallCoupon;
import com.minimall.db.domain.LitemallCouponUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class CouponVerifyService {

    @Autowired
    private LitemallCouponUserService couponUserService;
    @Autowired
    private LitemallCouponService couponService;

    /**
     * 检测优惠券是否适合
     *
     * @param userId
     * @param couponId
     * @param checkedGoodsPrice
     * @return
     */
    public LitemallCoupon checkCoupon(Integer userId, Integer couponId, BigDecimal checkedGoodsPrice) {
        LitemallCoupon coupon = couponService.findById(couponId);
        LitemallCouponUser couponUser = couponUserService.queryOne(userId, couponId);
        if (coupon == null || couponUser == null) {
            return null;
        }

        // 检查是否超期
        Short timeType = coupon.getTimeType();
        Short days = coupon.getDays();
        Date now = new Date();
        if (timeType.equals(org.linlinjava.litemall.db.util.CouponConstant.TIME_TYPE_TIME)) {
            if (now.before(coupon.getStartTime()) || now.after(coupon.getEndTime())) {
                return null;
            }
        }
        else if(timeType.equals(org.linlinjava.litemall.db.util.CouponConstant.TIME_TYPE_DAYS)) {
            Date expired = DateUtil.addDays(couponUser.getAddTime(),days);
            if (now.after(expired)) {
                return null;
            }
        }
        else {
            return null;
        }

        // 检测商品是否符合
        // TODO 目前仅支持全平台商品，所以不需要检测
        Short goodType = coupon.getGoodsType();
        if (!goodType.equals(org.linlinjava.litemall.db.util.CouponConstant.GOODS_TYPE_ALL)) {
            return null;
        }

        // 检测订单状态
        Short status = coupon.getStatus();
        if (!status.equals(org.linlinjava.litemall.db.util.CouponConstant.STATUS_NORMAL)) {
            return null;
        }
        // 检测是否满足最低消费
        if (checkedGoodsPrice.compareTo(coupon.getMin()) == -1) {
            return null;
        }

        return coupon;
    }

}
