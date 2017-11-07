package com.handsome.shop.dao;

import com.handsome.shop.bean.AttrComb;
import com.handsome.shop.bean.AttrValue;
import com.handsome.shop.bean.Goods;
import com.wangrj.java_lib.math.combination.ArrangementUtil;
import com.wangrj.java_lib.mybatis.MybatisDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@MapperScan
@Repository
public interface AttrCombDao extends MybatisDao<AttrComb> {

    default boolean createCombination(Goods goods, double price, int remainCount, AttrValue... attrValue) throws SQLException {
        List<List<AttrValue>> list = ArrangementUtil.arrangementRecursive(Arrays.asList(attrValue));
        boolean succeed = true;
        for (int i = 0; i < list.size(); i++) {
            List<AttrValue> attrValueList = list.get(i);
            if (!insert(goods, price + i, remainCount + i, attrValueList)) {
                succeed = false;
            }
        }
        return succeed;
    }

    default boolean insert(Goods goods, double price, int remainCount, List<AttrValue> attrValueList) throws SQLException {
        if (attrValueList.size() >= 10) {
            throw new SQLException("attribute count >= 10");
        }
        AttrComb attrComb = new AttrComb(goods, price, remainCount,
                attrValueList.size() < 1 ? null : attrValueList.get(0),
                attrValueList.size() < 2 ? null : attrValueList.get(1),
                attrValueList.size() < 3 ? null : attrValueList.get(2),
                attrValueList.size() < 4 ? null : attrValueList.get(3),
                attrValueList.size() < 5 ? null : attrValueList.get(4),
                attrValueList.size() < 6 ? null : attrValueList.get(5),
                attrValueList.size() < 7 ? null : attrValueList.get(6),
                attrValueList.size() < 8 ? null : attrValueList.get(7),
                attrValueList.size() < 9 ? null : attrValueList.get(8)
        );
        return insert(attrComb);
    }

}
