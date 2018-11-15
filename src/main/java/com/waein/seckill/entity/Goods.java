package com.waein.seckill.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: Goods, v 0.1
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
public class Goods {
    private Long id;

    private String goodsName;

    private String goodsTitle;

    private String goodsImg;

    private BigDecimal goodsPrice;

    private Integer goodsStock;

    private Date createDate;

    private Date updateDate;

    private String goodsDetail;
}