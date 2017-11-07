package com.handsome.shop.test;

import com.handsome.shop.bean.*;
import com.handsome.shop.dao.*;
import com.wangrj.java_lib.db3.DbUtil;
import com.wangrj.java_lib.java_util.DateUtil;
import com.wangrj.java_lib.mybatis.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public class DaoTest {

    private CustomerDao customerDao;
    private SellerDao sellerDao;
    private ShopDao shopDao;
    private GoodsCategoryDao categoryDao;
    private GoodsDao goodsDao;
    private GoodsImageDao goodsImageDao;
    private AttrNameDao attrNameDao;
    private AttrValueDao attrValueDao;
    private AttrCombDao attrCombDao;
    private OrdersDao ordersDao;
    private OrdersDetailDao ordersDetailDao;
    private CartDao cartDao;
    private EvaluateDao evaluateDao;
    private AreaDao areaDao;
    private AddressDao addressDao;

    @Test
    public void testQuery() {
//        LogUtil.printEntity(customerDao.queryByPhone("15521302230"));
//        LogUtil.printEntity(customerDao.countGender());
//
//        LogUtil.printEntity(shopDao.queryAll(), "seller");
//
//        LogUtil.printEntity(categoryDao.queryAll());
//
//        LogUtil.printEntity(cartDao.queryCountByCustomerId(25), "customer", "goodsType", "shop", "goodsImageList");
//
//        LogUtil.printEntity(goodsImageDao.queryByGoodsId(17), "goods");
//        LogUtil.printEntity(goodsImageDao.queryAll(), "goods");
//
//        LogUtil.printEntity(goodsDao.queryCountByShopId(13));
//        LogUtil.printEntity(goodsDao.queryByShopId(13, 0, 0), "goodsType", "shop", "goodsImageList");
//        LogUtil.printEntity(goodsDao.queryCountByCustomerId(25));
//        LogUtil.printEntity(goodsDao.queryByCustomerId(25, 0, 0), "goodsType", "shop", "goodsImageList");
//        LogUtil.printEntity(goodsDao.queryCountByGoodsTypeId(1));
//        LogUtil.printEntity(goodsDao.queryByGoodsTypeId(1, 0, 0), "goodsType", "shop", "goodsImageList");
//        LogUtil.printEntity(goodsDao.queryCountBySearchWord("3"));
//        LogUtil.printEntity(goodsDao.queryBySearchWord("3", 0, 0), "goodsType", "shop", "goodsImageList");
//
//        LogUtil.printEntity(ordersDao.queryCountByCustomerId(25));
//        LogUtil.printEntity(ordersDao.queryByCustomerId(25), "customer", "goodsType", "shop", "goodsImageList");
//        LogUtil.printEntity(ordersDao.queryCountByGoodsId(17));
//
//        LogUtil.printEntity(addressDao.queryByCustomerId(25), "customer");
//
//        LogUtil.printEntity(evaluateDao.queryByGoodsId(17));
    }

    @Test
    public void testUpdate() {
//        HibernateDao.buildSessionFactory();
//
//        String s = "newHeadUrl: " + MathUtil.random(0, 100);
//        System.out.println(s);
//        customerDao.updateHeadUrl(31, s);
//        Customer customer = customerDao.queryById(31);
//        System.out.println(customer.getHeadUrl());
//
//        HibernateDao.closeSessionFactory();
    }

    @Test
    public void testInsert() throws Exception {
        testDropAndCreate();

        Customer 英俊 = new Customer("15521302230", "123", "英俊", "英俊", 1, "/admin/img/customer_1.jpg");
        Customer 沫沫 = new Customer("13023796942", "123", "沫沫", "沫宝儿", 0, "/admin/img/customer_2.jpg");
        customerDao.insert(英俊);
        customerDao.insert(沫沫);

        Seller 张三 = new Seller("110", "123", "张三", "明月公主", 0, "/admin/img/seller_1.jpg");
        Seller 李四 = new Seller("120", "123", "李四", "型男", 1, "/admin/img/seller_2.jpg");
        Shop 东方电脑城 = new Shop(张三, "东方电脑城", "专卖电脑及其设备", "/admin/img/shop_1.jpg");
        Shop 手机旗舰店 = new Shop(张三, "手机旗舰店", "出售最新的三星，苹果手机", "/admin/img/shop_2.jpg");
        Shop 生鲜店 = new Shop(李四, "生鲜店", "各种新鲜水果，蔬菜应有尽有！", "/admin/img/shop_3.jpg");
        Shop 零食店 = new Shop(李四, "零食店", "吃货预备营！", "/admin/img/shop_4.jpg");

        GoodsCategory 电子产品 = new GoodsCategory("电子产品", null);
        GoodsCategory 手机 = new GoodsCategory("手机", 电子产品);
        GoodsCategory 笔记本 = new GoodsCategory("笔记本", 电子产品);
        GoodsCategory 移动电源 = new GoodsCategory("移动电源", 电子产品);
        categoryDao.insert(电子产品);
        categoryDao.insert(手机);
        categoryDao.insert(笔记本);
        categoryDao.insert(移动电源);

        GoodsCategory 食品 = new GoodsCategory("食品", null);
        GoodsCategory 果蔬 = new GoodsCategory("果蔬", 食品);
        GoodsCategory 零食 = new GoodsCategory("零食", 食品);
        GoodsCategory 饮料 = new GoodsCategory("饮料", 食品);
        categoryDao.insert(食品);
        categoryDao.insert(果蔬);
        categoryDao.insert(零食);
        categoryDao.insert(饮料);

        GoodsCategory 服装 = new GoodsCategory("服装", null);
        GoodsCategory 男装 = new GoodsCategory("男装", 服装);
        GoodsCategory 女装 = new GoodsCategory("女装", 服装);
        GoodsCategory 童装 = new GoodsCategory("童装", 服装);
        GoodsCategory 夏装 = new GoodsCategory("夏装", 服装);
        GoodsCategory 冬装 = new GoodsCategory("冬装", 服装);
        categoryDao.insert(服装);
        categoryDao.insert(男装);
        categoryDao.insert(女装);
        categoryDao.insert(童装);
        categoryDao.insert(夏装);
        categoryDao.insert(冬装);

        Goods 宏基笔记本 = new Goods("宏基笔记本", "Aspire最新版", 20, 笔记本, 东方电脑城, 3200);
        Goods 苹果笔记本 = new Goods("苹果笔记本", "超薄迷你", 60, 笔记本, 东方电脑城, 5400);
        Goods 三星E7手机 = new Goods("三星E7手机", "E7系列", 38, 手机, 手机旗舰店, 1500);
        Goods iPhone7手机 = new Goods("iPhone7手机", "乔布斯呕心沥血之作！", 8, 手机, 手机旗舰店, 5000);
        Goods 罗马士充电宝 = new Goods("罗马士充电宝", "大容量", 8, 手机, 手机旗舰店, 100);
        Goods 菜心 = new Goods("菜心", "新鲜的菜心，纯天然无农药", 200, 果蔬, 生鲜店, 7.5);
        Goods 苹果 = new Goods("苹果", "新鲜的苹果，纯天然无农药", 80, 果蔬, 生鲜店, 11.2);
        Goods 辣条 = new Goods("辣条", "老外都抢着吃，欲购从速！", 250, 零食, 零食店, 2.5);
        Goods 可乐 = new Goods("可乐", "透心凉，心飞扬！", 300, 饮料, 零食店, 5);

        sellerDao.insert(张三);
        sellerDao.insert(李四);
        shopDao.insert(东方电脑城);
        shopDao.insert(手机旗舰店);
        shopDao.insert(生鲜店);
        shopDao.insert(零食店);
        goodsDao.insert(宏基笔记本);
        goodsDao.insert(苹果笔记本);
        goodsDao.insert(三星E7手机);
        goodsDao.insert(iPhone7手机);
        goodsDao.insert(罗马士充电宝);
        goodsDao.insert(菜心);
        goodsDao.insert(苹果);
        goodsDao.insert(辣条);
        goodsDao.insert(可乐);

        goodsImageDao.insert(new GoodsImage(宏基笔记本, "/admin/img/goods_1.jpg"));
        goodsImageDao.insert(new GoodsImage(宏基笔记本, "/admin/img/goods_2.jpg"));
        goodsImageDao.insert(new GoodsImage(宏基笔记本, "/admin/img/goods_3.jpg"));
        goodsImageDao.insert(new GoodsImage(宏基笔记本, "/admin/img/goods_4.jpg"));
        goodsImageDao.insert(new GoodsImage(宏基笔记本, "/admin/img/goods_5.jpg"));
        goodsImageDao.insert(new GoodsImage(苹果笔记本, "/admin/img/goods_6.jpg"));
        goodsImageDao.insert(new GoodsImage(苹果笔记本, "/admin/img/goods_7.jpg"));
        goodsImageDao.insert(new GoodsImage(苹果笔记本, "/admin/img/goods_8.jpg"));
        goodsImageDao.insert(new GoodsImage(三星E7手机, "/admin/img/goods_9.jpg"));
        goodsImageDao.insert(new GoodsImage(三星E7手机, "/admin/img/goods_10.jpg"));
        goodsImageDao.insert(new GoodsImage(iPhone7手机, "/admin/img/goods_11.jpg"));
        goodsImageDao.insert(new GoodsImage(iPhone7手机, "/admin/img/goods_12.jpg"));
        goodsImageDao.insert(new GoodsImage(菜心, "/admin/img/goods_13.jpg"));
        goodsImageDao.insert(new GoodsImage(菜心, "/admin/img/goods_14.jpg"));
        goodsImageDao.insert(new GoodsImage(菜心, "/admin/img/goods_15.jpg"));
        goodsImageDao.insert(new GoodsImage(苹果, "/admin/img/goods_16.jpg"));
        goodsImageDao.insert(new GoodsImage(辣条, "/admin/img/goods_17.jpg"));
        goodsImageDao.insert(new GoodsImage(可乐, "/admin/img/goods_18.jpg"));
        goodsImageDao.insert(new GoodsImage(可乐, "/admin/img/goods_19.jpg"));

        // 商品属性名
        AttrName rom = new AttrName("内存", iPhone7手机);
        AttrName color = new AttrName("颜色", iPhone7手机);
        AttrName cpu = new AttrName("处理器", 三星E7手机);
        AttrName size = new AttrName("容量", 三星E7手机);
        AttrName internet = new AttrName("网络版本", 三星E7手机);
        attrNameDao.insert(rom);
        attrNameDao.insert(color);
        attrNameDao.insert(cpu);
        attrNameDao.insert(size);
        attrNameDao.insert(internet);

        // 商品属性值
        AttrValue rom2G = new AttrValue("2G", rom);
        AttrValue rom4G = new AttrValue("4G", rom);
        AttrValue black = new AttrValue("黑色", color);
        AttrValue white = new AttrValue("白色", color);
        AttrValue cpuTwo = new AttrValue("双核", cpu);
        AttrValue cpuFour = new AttrValue("四核", cpu);
        AttrValue size16G = new AttrValue("16G", size);
        AttrValue size64G = new AttrValue("64G", size);
        AttrValue lianTong4G = new AttrValue("联通4G", internet);
        AttrValue yiDong4G = new AttrValue("移动4G", internet);
        AttrValue dianXin4G = new AttrValue("电信4G", internet);
        attrValueDao.insert(rom2G);
        attrValueDao.insert(rom4G);
        attrValueDao.insert(black);
        attrValueDao.insert(white);
        attrValueDao.insert(cpuTwo);
        attrValueDao.insert(cpuFour);
        attrValueDao.insert(size16G);
        attrValueDao.insert(size64G);
        attrValueDao.insert(lianTong4G);
        attrValueDao.insert(yiDong4G);
        attrValueDao.insert(dianXin4G);

        // 创建商品的所有属性值组合5
        attrCombDao.createCombination(iPhone7手机, iPhone7手机.getPrice(), 10, rom2G, rom4G, black, white);
        attrCombDao.createCombination(三星E7手机, 三星E7手机.getPrice(), 20, cpuTwo, cpuFour, size16G, size64G, dianXin4G);

        cartDao.insert(new Cart(英俊, iPhone7手机, 3));
        cartDao.insert(new Cart(英俊, 苹果笔记本, 1));
        cartDao.insert(new Cart(沫沫, iPhone7手机, 1));
        cartDao.insert(new Cart(沫沫, 苹果, 20));

        Area 广东省 = new Area("广东省", null);
        Area 广州市 = new Area("广州市", 广东省);
        Area 番禺区 = new Area("番禺区", 广州市);
        Area 天河区 = new Area("天河区", 广州市);
        areaDao.insert(广东省);
        areaDao.insert(广州市);
        areaDao.insert(番禺区);
        areaDao.insert(天河区);

        Address address1 = new Address(英俊, 番禺区, "广州大学城XX学校XX宿舍");
        Address address2 = new Address(沫沫, 天河区, "车陂冬景花园XX座XX号");
        addressDao.insert(address1);
        addressDao.insert(address2);

        Orders orders1 = new Orders(英俊, 3500d, "", "15521302230", "英俊", address1.getStreet(), d("2016-04-14"), Orders.STATE_CONTINUE);
        OrdersDetail detail_英俊_三星E7手机 = new OrdersDetail(orders1, 三星E7手机, 三星E7手机.getGoodsName(), 1, 三星E7手机.getPrice());
        OrdersDetail detail_英俊_宏基笔记本 = new OrdersDetail(orders1, 宏基笔记本, 宏基笔记本.getGoodsName(), 1, 宏基笔记本.getPrice());
        Orders orders2 = new Orders(英俊, 23d, "辣条要海鲜味", "15521302230", "英俊", address1.getStreet(), d("2016-04-14"), Orders.STATE_CONTINUE);
        OrdersDetail detail_英俊_菜心 = new OrdersDetail(orders2, 菜心, 菜心.getGoodsName(), 6, 菜心.getPrice());
        OrdersDetail detail_英俊_辣条 = new OrdersDetail(orders2, 辣条, 辣条.getGoodsName(), 10, 辣条.getPrice());
        Orders orders3 = new Orders(沫沫, 4900d, "记得发手机套", "13023796942", "沫宝儿", address1.getStreet(), d("2015-03-14"), Orders.STATE_SUCCEED);
        OrdersDetail detail_沫沫_iPhone7手机 = new OrdersDetail(orders3, iPhone7手机, iPhone7手机.getGoodsName(), 1, iPhone7手机.getPrice());
        Orders orders4 = new Orders(沫沫, 3000d, "", "13023796942", "沫宝儿", address1.getStreet(), d("2015-04-12"), Orders.STATE_SUCCEED);
        OrdersDetail detail_沫沫_宏基笔记本 = new OrdersDetail(orders4, 宏基笔记本, 宏基笔记本.getGoodsName(), 1, 宏基笔记本.getPrice());
        Orders orders5 = new Orders(沫沫, 98d, "", "13023796942", "沫宝儿", address1.getStreet(), d("2015-04-12"), Orders.STATE_CONTINUE);
        OrdersDetail detail_沫沫_可乐 = new OrdersDetail(orders5, 可乐, 可乐.getGoodsName(), 5, 可乐.getPrice());
        OrdersDetail detail_沫沫_辣条 = new OrdersDetail(orders5, 辣条, 辣条.getGoodsName(), 20, 辣条.getPrice());
        ordersDao.insert(orders1);
        ordersDao.insert(orders2);
        ordersDao.insert(orders3);
        ordersDao.insert(orders4);
        ordersDao.insert(orders5);
        ordersDetailDao.insert(detail_英俊_三星E7手机);
        ordersDetailDao.insert(detail_英俊_宏基笔记本);
        ordersDetailDao.insert(detail_英俊_菜心);
        ordersDetailDao.insert(detail_英俊_辣条);
        ordersDetailDao.insert(detail_沫沫_iPhone7手机);
        ordersDetailDao.insert(detail_沫沫_宏基笔记本);
        ordersDetailDao.insert(detail_沫沫_可乐);
        ordersDetailDao.insert(detail_沫沫_辣条);

        evaluateDao.insert(new Evaluate(detail_英俊_三星E7手机, "三星E7用了很久了，质量很好！好评！", Evaluate.LEVEL_GOOD, d("2016-05-12")));
        evaluateDao.insert(new Evaluate(detail_英俊_宏基笔记本, "电脑一般吧，有时很卡", Evaluate.LEVEL_NORMAL, d("2015-01-12")));
        evaluateDao.insert(new Evaluate(detail_沫沫_iPhone7手机, "苹果的ISO系统一直很快，装逼利器！", Evaluate.LEVEL_GOOD, d("2015-03-07")));
        evaluateDao.insert(new Evaluate(detail_沫沫_宏基笔记本, "什么破电脑，买了没几天就坏了", Evaluate.LEVEL_BAD, d("2015-05-22")));
    }

    @Test
    public void testDropAndCreate() throws ClassNotFoundException {
        List<Class> pojoClassList = new ArrayList<>();
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.getName().endsWith("Dao")) {
                continue;
            }
            String pojoClassName = field.getType().getName().replace(".dao.", ".bean.");
            pojoClassName = pojoClassName.substring(0, pojoClassName.length() - 3);// 去除末尾的Dao
            System.out.println(pojoClassName);
            pojoClassList.add(Class.forName(pojoClassName));
        }
        DbUtil.dropAndCreateTables(DbUtil.DbType.Oracle, "orcl", "wang", "123", pojoClassList);
    }

    /**
     * 添加无意义商品记录10000条
     */
    @Test
    public void testInsertUselessGoods() throws IOException {
        for (int i = 1; i <= 10000; i++) {
            Goods goods = new Goods("商品" + i, "商品描述" + i,
                    i, new GoodsCategory(i % 2 + 1), new Shop(1), 500 + i * 100);
            goodsDao.insert(goods);
            GoodsImage goodsImage = new GoodsImage(goods, "/admin/img/goods_" + (i % 19 + 1) + ".jpg");
            goodsImageDao.insert(goodsImage);
        }
    }

    private SqlSession session;

    @Before
    public void init() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        session = new SqlSessionFactoryBuilder().build(is).openSession();
        MybatisUtil.initDao(this, session);
    }

    @After
    public void close() {
        session.commit();
        session.close();
    }

    private Date d(String date) {
        return DateUtil.toDate(date);
    }

}
