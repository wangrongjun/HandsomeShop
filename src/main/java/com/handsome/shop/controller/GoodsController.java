package com.handsome.shop.controller;

import com.handsome.shop.bean.Goods;
import com.handsome.shop.dao.GoodsDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * by wangrongjun on 2017/11/2.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsDao goodsDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView showGoodsInfo(@PathVariable int id) {
        Goods goods = goodsDao.queryById(id);
        ModelAndView mav = new ModelAndView("/WEB-INF/page/goods_info.jsp");
        mav.addObject("goods", goods);
        return mav;
    }

}
