package com.waein.seckill.service;

import com.waein.seckill.entity.User;
import com.waein.seckill.param.LoginParam;
import com.waein.seckill.result.Result;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: UserService, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
public interface UserService {
    Result<User> login(LoginParam loginParam);
}
