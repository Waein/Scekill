package com.waein.seckill.service;

import com.waein.seckill.bo.GoodsBo;
import com.waein.seckill.entity.OrderInfo;
import com.waein.seckill.entity.SeckillOrder;
import com.waein.seckill.entity.User;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: SeckillOrderService, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
public interface SeckillOrderService {

    SeckillOrder getSeckillOrderByUserIdGoodsId(long userId, long goodsId);

    OrderInfo insert(User user, GoodsBo goodsBo);

}
