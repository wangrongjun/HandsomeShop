package com.handsome.shop.controller;

import com.handsome.shop.bean.Evaluate;
import com.handsome.shop.bean.Goods;
import com.handsome.shop.dao.EvaluateDao;
import com.handsome.shop.dao.GoodsDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * by wangrongjun on 2017/11/2.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsDao goodsDao;
    @Resource
    private EvaluateDao evaluateDao;

    @RequestMapping(value = "/{goodsId}", method = RequestMethod.GET)
    public ModelAndView showGoodsInfo(@PathVariable int goodsId) {
        Goods goods = goodsDao.queryById(goodsId);
        List<Evaluate> evaluateList = evaluateDao.queryByGoodsId(goodsId);
        return new ModelAndView("goods_info").
                addObject("goods", goods).
                addObject("evaluateList", evaluateList);
    }

}
