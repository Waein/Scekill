package com.waein.seckill.service.impl;

import com.waein.seckill.entity.User;
import com.waein.seckill.dao.UserMapper;
import com.waein.seckill.param.LoginParam;
import com.waein.seckill.result.CodeMsg;
import com.waein.seckill.result.Result;
import com.waein.seckill.service.UserService;
import com.waein.seckill.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: UserServiceImpl, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Result<User> login(LoginParam loginParam) {

        User user = userMapper.checkPhone(loginParam.getMobile());
        if (user == null) {
            return Result.error(CodeMsg.MOBILE_NOT_EXIST);
        }
        String dbPwd = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(loginParam.getPassword(), saltDB);
        if (!StringUtils.equals(dbPwd, calcPass)) {
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        user.setPassword(StringUtils.EMPTY);
        return Result.success(user);
    }
}
