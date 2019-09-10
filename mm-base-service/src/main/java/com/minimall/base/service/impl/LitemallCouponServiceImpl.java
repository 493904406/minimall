package com.minimall.base.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.minimall.base.domain.entity.LitemallCoupon;
import com.minimall.base.domain.entity.LitemallCoupon.Column;
import com.minimall.base.domain.entity.LitemallCouponExample;
import com.minimall.base.domain.entity.LitemallCouponUser;
import com.minimall.base.domain.entity.LitemallCouponUserExample;
import com.minimall.base.mapper.LitemallCouponMapper;
import com.minimall.base.mapper.LitemallCouponUserMapper;
import com.minimall.base.service.LitemallCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/10
 * @mail yxb_825@163.com
 */
@Service
public class LitemallCouponServiceImpl implements LitemallCouponService {
    @Autowired
    private LitemallCouponMapper couponMapper;
    @Autowired
    private LitemallCouponUserMapper couponUserMapper;

    private Column[] result = new Column[]{Column.id, Column.name, Column.desc, Column.tag,
                                            Column.days, Column.startTime, Column.endTime,
                                            Column.discount, Column.min};

    /**
     * 查询，空参数
     *
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @Override
    public List<LitemallCoupon> queryList(int offset, int limit, String sort, String order) {
        return queryList(LitemallCouponExample.newAndCreateCriteria(), offset, limit, sort, order);
    }

    /**
     * 查询
     *
     * @param criteria 可扩展的条件
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @Override
    public List<LitemallCoupon> queryList(LitemallCouponExample.Criteria criteria, int offset, int limit, String sort, String order) {
        criteria.andTypeEqualTo(org.linlinjava.litemall.db.util.CouponConstant.TYPE_COMMON).andStatusEqualTo(org.linlinjava.litemall.db.util.CouponConstant.STATUS_NORMAL).andDeletedEqualTo(false);
        criteria.example().setOrderByClause(sort + " " + order);
        PageHelper.startPage(offset, limit);
        return couponMapper.selectByExampleSelective(criteria.example(), result);
    }

    @Override
    public List<LitemallCoupon> queryAvailableList(Integer userId, int offset, int limit) {
        assert userId != null;
        // 过滤掉登录账号已经领取过的coupon
        LitemallCouponExample.Criteria c = LitemallCouponExample.newAndCreateCriteria();
        List<LitemallCouponUser> used = couponUserMapper.selectByExample(
                LitemallCouponUserExample.newAndCreateCriteria().andUserIdEqualTo(userId).example()
        );
        if(used!=null && !used.isEmpty()){
            c.andIdNotIn(used.stream().map(LitemallCouponUser::getCouponId).collect(Collectors.toList()));
        }
        return queryList(c, offset, limit, "add_time", "desc");
    }

    @Override
    public List<LitemallCoupon> queryList(int offset, int limit) {
        return queryList(offset, limit, "add_time", "desc");
    }

    @Override
    public LitemallCoupon findById(Integer id) {
        return couponMapper.selectByPrimaryKey(id);
    }


    @Override
    public LitemallCoupon findByCode(String code) {
        LitemallCouponExample example = new LitemallCouponExample();
        example.or().andCodeEqualTo(code).andTypeEqualTo(org.linlinjava.litemall.db.util.CouponConstant.TYPE_CODE).andStatusEqualTo(org.linlinjava.litemall.db.util.CouponConstant.STATUS_NORMAL).andDeletedEqualTo(false);
        List<LitemallCoupon> couponList =  couponMapper.selectByExample(example);
        if(couponList.size() > 1){
            throw new RuntimeException("");
        }
        else if(couponList.size() == 0){
            return null;
        }
        else {
            return couponList.get(0);
        }
    }

    /**
     * 查询新用户注册优惠券
     *
     * @return
     */
    @Override
    public List<LitemallCoupon> queryRegister() {
        LitemallCouponExample example = new LitemallCouponExample();
        example.or().andTypeEqualTo(org.linlinjava.litemall.db.util.CouponConstant.TYPE_REGISTER).andStatusEqualTo(org.linlinjava.litemall.db.util.CouponConstant.STATUS_NORMAL).andDeletedEqualTo(false);
        return couponMapper.selectByExample(example);
    }

    @Override
    public List<LitemallCoupon> querySelective(String name, Short type, Short status, Integer page, Integer limit, String sort, String order) {
        LitemallCouponExample example = new LitemallCouponExample();
        LitemallCouponExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return couponMapper.selectByExample(example);
    }

    @Override
    public void add(LitemallCoupon coupon) {
        coupon.setAddTime(new Date());
        coupon.setUpdateTime(new Date());
        couponMapper.insertSelective(coupon);
    }

    @Override
    public int updateById(LitemallCoupon coupon) {
        coupon.setUpdateTime(new Date());
        return couponMapper.updateByPrimaryKeySelective(coupon);
    }

    @Override
    public void deleteById(Integer id) {
        couponMapper.logicalDeleteByPrimaryKey(id);
    }

    private String getRandomNum(Integer num) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        base += "0123456789";

        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成优惠码
     *
     * @return 可使用优惠码
     */
    @Override
    public String generateCode() {
        String code = getRandomNum(8);
        while(findByCode(code) != null){
            code = getRandomNum(8);
        }
        return code;
    }

    /**
     * 查询过期的优惠券:
     * 注意：如果timeType=0, 即基于领取时间有效期的优惠券，则优惠券不会过期
     *
     * @return
     */
    @Override
    public List<LitemallCoupon> queryExpired() {
        LitemallCouponExample example = new LitemallCouponExample();
        example.or().andStatusEqualTo(org.linlinjava.litemall.db.util.CouponConstant.STATUS_NORMAL).
                andTimeTypeEqualTo(org.linlinjava.litemall.db.util.CouponConstant.TIME_TYPE_TIME).
                andEndTimeLessThan(new Date()).andDeletedEqualTo(false);
        return couponMapper.selectByExample(example);
    }
}
