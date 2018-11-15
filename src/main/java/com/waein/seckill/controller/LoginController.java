package com.waein.seckill.controller;

import com.waein.seckill.common.Constant;
import com.waein.seckill.entity.User;
import com.waein.seckill.param.LoginParam;
import com.waein.seckill.redis.RedisService;
import com.waein.seckill.redis.UserKey;
import com.waein.seckill.result.Result;
import com.waein.seckill.service.UserService;
import com.waein.seckill.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: LoginController, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    RedisService redisService;
    @Autowired
    UserService userService;

    /**
     * 用户登陆页面
     *
     * @return
     */
    @RequestMapping("/login/page")
    public String loginPage() {
        //thymeleaf跳转到login页面
        return "login";
    }

    /**
     * 用户登陆
     *
     * @param response
     * @param session
     * @param loginParam
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result<User> doLogin(HttpServletResponse response, HttpSession session, @Valid LoginParam loginParam) {
        Result<User> login = userService.login(loginParam);
        if (login.isSuccess()) {
            CookieUtil.writeLoginToken(response, session.getId());
            redisService.set(UserKey.getByName, session.getId(), login.getData(), Constant.RedisCacheExtime.REDIS_SESSION_EXTIME);
        }
        return login;
    }

    /**
     * 用户登出
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/logout")
    public String doLogout(HttpServletRequest request, HttpServletResponse response) {
        String token = CookieUtil.readLoginToken(request);
        CookieUtil.delLoginToken(request, response);
        redisService.del(UserKey.getByName, token);
        return "login";
    }
}
