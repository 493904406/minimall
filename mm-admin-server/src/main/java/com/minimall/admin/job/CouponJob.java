package com.minimall.admin.job;

import com.minimall.base.domain.entity.LitemallCoupon;
import com.minimall.base.service.LitemallCouponService;
import com.minimall.user.domain.entity.LitemallCouponUser;
import com.minimall.user.service.LitemallCouponUserService;
import com.minimall.user.util.CouponConstant;
import com.minimall.user.util.CouponUserConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 检测优惠券过期情况
 */
@Component
public class CouponJob {
    private final Log logger = LogFactory.getLog(CouponJob.class);

    @Autowired
    private LitemallCouponService couponService;
    @Autowired
    private LitemallCouponUserService couponUserService;

    /**
     * 每隔一个小时检查
     * TODO
     * 注意，因为是相隔一个小时检查，因此导致优惠券真正超时时间可能比设定时间延迟1个小时
     */
    @Scheduled(fixedDelay = 60 * 60 * 1000)
    public void checkCouponExpired() {
        logger.info("系统开启任务检查优惠券是否已经过期");

        List<LitemallCoupon> couponList = couponService.queryExpired();
        for (LitemallCoupon coupon : couponList) {
            coupon.setStatus(CouponConstant.STATUS_EXPIRED);
            couponService.updateById(coupon);
        }

        List<LitemallCouponUser> couponUserList = couponUserService.queryExpired();
        for (LitemallCouponUser couponUser : couponUserList) {
            couponUser.setStatus(CouponUserConstant.STATUS_EXPIRED);
            couponUserService.update(couponUser);
        }
    }

}
