package com.waein.seckill.controller;

import com.waein.seckill.bo.GoodsBo;
import com.waein.seckill.entity.User;
import com.waein.seckill.redis.RedisService;
import com.waein.seckill.redis.UserKey;
import com.waein.seckill.service.SeckillGoodsService;
import com.waein.seckill.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: GoodsController, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    RedisService redisService;

    @Autowired
    SeckillGoodsService seckillGoodsService;

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<GoodsBo> goodsList = seckillGoodsService.getSeckillGoodsList();
        model.addAttribute("goodsList", goodsList);
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String detail(Model model, @PathVariable("goodsId") long goodsId, HttpServletRequest request, HttpServletResponse response) {

        String loginToken = CookieUtil.readLoginToken(request);
        User user = redisService.get(UserKey.getByName, loginToken, User.class);
        model.addAttribute("user", user);
        GoodsBo goods = seckillGoodsService.getSeckillGoodsBoByGoodsId(goodsId);
        if (goods == null) {
            return "error/404";
        } else {
            model.addAttribute("goods", goods);
            long startAt = goods.getStartDate().getTime();
            long endAt = goods.getEndDate().getTime();
            long now = System.currentTimeMillis();

            int miaoshaStatus = 0;
            int remainSeconds = 0;
            if (now < startAt) {
                //秒杀还没开始，倒计时
                miaoshaStatus = 0;
                remainSeconds = (int) ((startAt - now) / 1000);
            } else if (now > endAt) {
                //秒杀已经结束
                miaoshaStatus = 2;
                remainSeconds = -1;
            } else {
                //秒杀进行中
                miaoshaStatus = 1;
                remainSeconds = 0;
            }
            model.addAttribute("miaoshaStatus", miaoshaStatus);
            model.addAttribute("remainSeconds", remainSeconds);
            return "goods_detail";
        }
    }
}

