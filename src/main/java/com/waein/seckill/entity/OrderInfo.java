package com.waein.seckill.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: OrderInfo, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {
    private Long id;

    private Long userId;

    private Long goodsId;

    private Long addrId;

    private String goodsName;

    private Integer goodsCount;

    private BigDecimal goodsPrice;

    private Integer orderChannel;

    private Integer status;

    private Date createDate;

    private Date payDate;

}