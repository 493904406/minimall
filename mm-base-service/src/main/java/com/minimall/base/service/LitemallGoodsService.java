package com.minimall.base.service;
import com.minimall.base.domain.entity.LitemallGoods;

import java.util.List;
/**
 * @author yanxubin
 * @Description 商品
 * @date:2019/9/10
 * @mail yxb_825@163.com
 */
public interface LitemallGoodsService {
    /**
     * 获取热卖商品
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<LitemallGoods> queryByHot(int offset, int limit);

    /**
     * 获取新品上市
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<LitemallGoods> queryByNew(int offset, int limit);

    /**
     * 获取分类下的商品
     *
     * @param catList
     * @param offset
     * @param limit
     * @return
     */
    public List<LitemallGoods> queryByCategory(List<Integer> catList, int offset, int limit);


    /**
     * 获取分类下的商品
     *
     * @param catId
     * @param offset
     * @param limit
     * @return
     */
    public List<LitemallGoods> queryByCategory(Integer catId, int offset, int limit);


    public List<LitemallGoods> querySelective(Integer catId, Integer brandId, String keywords,
                                              Boolean isHot, Boolean isNew, Integer offset, Integer limit, String sort, String order);

    /**
     * 获取某个商品信息,包含完整信息
     *
     * @param id
     * @return
     */
    public LitemallGoods findById(Integer id);

    /**
     * 获取某个商品信息，仅展示相关内容
     *
     * @param id
     * @return
     */
    public LitemallGoods findByIdVO(Integer id);


    /**
     * 获取所有在售物品总数
     *
     * @return
     */
    public Integer queryOnSale();

    public int updateById(LitemallGoods goods);
    public void deleteById(Integer id);

    /**
     * 获取所有物品总数，包括在售的和下架的，但是不包括已删除的商品
     *
     * @return
     */
    public int count();

    public List<Integer> getCatIds(Integer brandId, String keywords, Boolean isHot, Boolean isNew);

    public boolean checkExistByName(String name);

    public List<LitemallGoods> queryByIds(Integer[] ids) ;
}
