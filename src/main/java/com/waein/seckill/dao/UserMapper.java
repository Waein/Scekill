package com.waein.seckill.dao;

import com.waein.seckill.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: UserMapper, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
public interface UserMapper {

    User selectByPhoneAndPassword(@Param("phone") String phone , @Param("password") String password);

    User checkPhone(@Param("phone") String phone );
}
