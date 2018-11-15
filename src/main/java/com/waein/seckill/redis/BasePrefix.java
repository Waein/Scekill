package com.waein.seckill.redis;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: BasePrefix, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
public abstract class BasePrefix implements KeyPrefix {

    private String prefix;

    public BasePrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }

}
