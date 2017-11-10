package com.handsome.shop.controller;

import com.handsome.shop.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * by wangrongjun on 2017/11/2.
 */
@Controller
public class IndexController {

    @Resource
    private IndexService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        String categoryListJson = service.getCategoryListJson();
        String foodGoodsListJson = service.getGoodsListJson("食品");// 只查询前8条数据
        String electricGoodsListJson = service.getGoodsListJson("电子产品");// 只是查询前8条数据

        return new ModelAndView("index").
                addObject("categoryListJson", categoryListJson).
                addObject("foodGoodsListJson", foodGoodsListJson).
                addObject("electricGoodsListJson", electricGoodsListJson);
    }

    @RequestMapping(value = "/withoutCache", method = RequestMethod.GET)
    public ModelAndView showIndexWithoutCache() {
        String categoryListJson = service.getCategoryListJsonWithoutCache();
        String foodGoodsListJson = service.getGoodsListJsonWithoutCache("食品");
        String electricGoodsListJson = service.getGoodsListJsonWithoutCache("电子产品");

        return new ModelAndView("index").
                addObject("categoryListJson", categoryListJson).
                addObject("foodGoodsListJson", foodGoodsListJson).
                addObject("electricGoodsListJson", electricGoodsListJson);
    }

}
