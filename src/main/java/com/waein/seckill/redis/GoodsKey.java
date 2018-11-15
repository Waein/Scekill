package com.waein.seckill.redis;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: GoodsKey, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
public class GoodsKey extends BasePrefix {
    private GoodsKey(String prefix) {
        super(prefix);
    }

    public static GoodsKey getGoodsList = new GoodsKey("gl");
    public static GoodsKey getGoodsDetail = new GoodsKey("gd");
}
