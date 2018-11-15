package com.waein.seckill.service;

import com.waein.seckill.bo.GoodsBo;

import java.util.List;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: SeckillGoodsService, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
public interface SeckillGoodsService {

    List<GoodsBo> getSeckillGoodsList();

    GoodsBo getSeckillGoodsBoByGoodsId(long goodsId);

    int reduceStock(long goodsId);
}
