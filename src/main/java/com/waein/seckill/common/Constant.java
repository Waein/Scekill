package com.waein.seckill.common;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: Constant, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
public class Constant {

    public interface RedisCacheExtime {
        int REDIS_SESSION_EXTIME = 60 * 30;//30分钟
        int GOODS_LIST = 60;//1分钟
        int GOODS_INFO = 60;//1分钟
    }
}
