package com.handsome.shop.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * by wangrongjun on 2017/11/3.
 */
public class LocListUtil {

    @SuppressWarnings("unchecked")
    public static void foreach(String xmlFilePath, Insert insert) throws Exception {
        Document document = new SAXReader().read(new File(xmlFilePath));
        Element root = document.getRootElement();// it根节点
        Element countryElement = root.element("CountryRegion");
        List<Element> provinceElementList = countryElement.elements("State");

        for (Element provinceElement : provinceElementList) {
            String provinceName = provinceElement.attributeValue("Name");
            String provinceCode = provinceElement.attributeValue("Code");
            Integer provinceId = insert.insert(1, provinceName, provinceCode, null);
            List<Element> cityElementList = provinceElement.elements("City");

            for (Element cityElement : cityElementList) {
                String cityName = cityElement.attributeValue("Name");
                String cityCode = cityElement.attributeValue("Code");
                Integer cityId = insert.insert(2, cityName, cityCode, provinceId);
                List<Element> regionElementList = cityElement.elements("Region");

                for (Element regionElement : regionElementList) {
                    String regionName = regionElement.attributeValue("Name");
                    String regionCode = regionElement.attributeValue("Code");
                    insert.insert(3, regionName, regionCode, cityId);
                }
            }
        }
    }

    interface Insert {
        /**
         * @param type 类型，省=1，市=2，区=3
         * @return 插入后生成的id，以作为下级的parentId
         */
        Integer insert(int type, String name, String code, Integer parentId);
    }

}
