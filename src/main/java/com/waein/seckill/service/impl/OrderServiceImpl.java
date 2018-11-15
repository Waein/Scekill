package com.waein.seckill.service.impl;

import com.waein.seckill.dao.OrderInfoMapper;
import com.waein.seckill.entity.OrderInfo;
import com.waein.seckill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: OrderServiceImpl, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderInfoMapper ordeInfoMapper;

    @Override
    public long addOrder(OrderInfo orderInfo) {
        return ordeInfoMapper.insertSelective(orderInfo);
    }
}
