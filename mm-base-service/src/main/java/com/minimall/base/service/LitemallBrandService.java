package com.minimall.base.service;
import com.minimall.base.domain.entity.LitemallBrand;
import java.util.List;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/10
 * @mail yxb_825@163.com
 */
public interface LitemallBrandService {


    List<LitemallBrand> query(Integer page, Integer limit, String sort, String order);

    List<LitemallBrand> query(Integer page, Integer limit);

    LitemallBrand findById(Integer id);

    List<LitemallBrand> querySelective(String id, String name, Integer page, Integer size, String sort, String order);

    int updateById(LitemallBrand brand);

    void deleteById(Integer id);

    void add(LitemallBrand brand);

    List<LitemallBrand> all();
}
