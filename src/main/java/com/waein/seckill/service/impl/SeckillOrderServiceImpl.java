package com.waein.seckill.service.impl;

import com.waein.seckill.bo.GoodsBo;
import com.waein.seckill.dao.SeckillOrderMapper;
import com.waein.seckill.entity.OrderInfo;
import com.waein.seckill.entity.SeckillOrder;
import com.waein.seckill.entity.User;
import com.waein.seckill.service.OrderService;
import com.waein.seckill.service.SeckillGoodsService;
import com.waein.seckill.service.SeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: SeckillOrderServiceImpl, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Service("seckillOrderService")
public class SeckillOrderServiceImpl implements SeckillOrderService {

    @Autowired
    SeckillOrderMapper seckillOrderMapper;

    @Autowired
    SeckillGoodsService seckillGoodsService;

    @Autowired
    OrderService orderService;

    @Override
    public SeckillOrder getSeckillOrderByUserIdGoodsId(long userId, long goodsId) {
        return seckillOrderMapper.selectByUserIdAndGoodsId(userId, goodsId);
    }

    @Transactional
    @Override
    public OrderInfo insert(User user, GoodsBo goods) {
        //秒杀商品库存减一
        seckillGoodsService.reduceStock(goods.getId());
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(new Date());
        orderInfo.setAddrId(0L);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setGoodsName(goods.getGoodsName());
        orderInfo.setGoodsPrice(goods.getSeckillPrice());
        orderInfo.setOrderChannel(1);
        orderInfo.setStatus(0);
        orderInfo.setUserId((long) user.getId());
        //添加信息进订单
        long orderId = orderService.addOrder(orderInfo);
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setGoodsId(goods.getId());
        seckillOrder.setOrderId(orderId);
        seckillOrder.setUserId((long) user.getId());
        //插入秒杀表
        seckillOrderMapper.insertSelective(seckillOrder);
        return orderInfo;
    }
}
