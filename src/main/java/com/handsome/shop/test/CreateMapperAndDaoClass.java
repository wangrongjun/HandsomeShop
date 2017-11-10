package com.handsome.shop.test;

import com.wangrj.java_lib.java_util.TextUtil;
import com.wangrj.java_lib.mybatis.mybatis_generator.MybatisCreator;

import java.io.File;
import java.io.FileWriter;

/**
 * by wangrongjun on 2017/11/6.
 */
public class CreateMapperAndDaoClass {

    private static String beanDir = "C:\\IDE\\ideaIU-project\\HandsomeShop\\src\\main\\java\\" +
            "com\\handsome\\shop\\bean\\";
    private static String daoDir = "C:\\IDE\\ideaIU-project\\HandsomeShop\\src\\main\\java\\" +
            "com\\handsome\\shop\\dao\\";

    public static void main(String[] args) throws Exception {
        File[] files = new File(beanDir).listFiles(pathname -> pathname.getName().endsWith(".java"));
        assert files != null;
        for (File file : files) {
            if (!file.getName().equals("GoodsCategory.java")) {
                continue;
            }
            String beanSimpleName = TextUtil.getTextExceptLastPoint(file.getName());
            String beanName = "com.handsome.shop.bean." + beanSimpleName;
            String daoSimpleName = beanSimpleName + "Dao";
            String daoName = "com.handsome.shop.dao." + daoSimpleName;

            Class beanClass = Class.forName(beanName);
            new MybatisCreator().createMapper(beanClass, daoName, new FileWriter(daoDir + daoSimpleName + ".xml"));
//            new MybatisCreator().setCreateAnno(true).
//                    createDao(beanClass, daoName, new FileWriter(daoDir + daoSimpleName + ".java"));
        }
    }

}
