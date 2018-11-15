package com.waein.seckill.exception;

import com.waein.seckill.result.CodeMsg;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: WaeinException, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
public class WaeinException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public WaeinException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }

}
