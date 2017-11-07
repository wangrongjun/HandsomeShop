package com.handsome.shop.controller;

import com.handsome.shop.bean.Goods;
import com.handsome.shop.bean.GoodsCategory;
import com.handsome.shop.dao.GoodsCategoryDao;
import com.handsome.shop.dao.GoodsDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * by wangrongjun on 2017/11/2.
 */
@Controller
public class IndexController {

    @Resource
    private GoodsDao goodsDao;
    @Resource
    private GoodsCategoryDao categoryDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView mav = new ModelAndView("/WEB-INF/page/index.jsp");

        List<Goods> goodsList = goodsDao.queryAllLimit(0, 8);
        mav.addObject("double11GoodsList", goodsList);

        List<GoodsCategory> categoryList = categoryDao.queryAll();

        return mav;
    }

}
