package com.waein.seckill.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: SeckillGoods, v 0.1
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
public class SeckillGoods {
    private Long id;

    private Long goodsId;

    private BigDecimal seckilPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;

}