package com.handsome.shop.test.old

import com.handsome.shop.bean.*
import com.wangrj.java_lib.db3.BaseDao
import com.wangrj.java_lib.db3.Config
import com.wangrj.java_lib.db3.Dao
import com.wangrj.java_lib.db3.db.OracleDatabase
import com.wangrj.java_lib.math.combination.ArrangementUtil
import java.sql.SQLException


/**
 * by wangrongjun on 2017/11/3.
 */
open class HandsomeDao<T> : BaseDao<T>(
        Config().setDb(OracleDatabase("orcl")).setUsername("wang").setPassword("123")
)

interface AreaDao : Dao<Area>
interface AddressDao : Dao<Address>
interface CartDao : Dao<Cart>
interface CustomerDao : Dao<Customer>
interface EvaluateDao : Dao<Evaluate>
interface GoodsCategoryDao : Dao<GoodsCategory>
interface GoodsDao : Dao<Goods>
interface GoodsImageDao : Dao<GoodsImage>
interface OrdersDao : Dao<Orders>
interface OrdersDetailDao : Dao<OrdersDetail>
interface SellerDao : Dao<Seller>
interface ShopDao : Dao<Shop>
interface AttrNameDao : Dao<AttrName>
interface AttrValueDao : Dao<AttrValue>
interface AttrCombDao : Dao<AttrComb> {
    fun createCombination(goods: Goods, remainCount: Int, price: Double, vararg attrValue: AttrValue): Boolean
    fun insert(goods: Goods, remainCount: Int, price: Double, attrValueList: List<AttrValue>): Boolean
}

class AreaDaoImpl : HandsomeDao<Area>(), AreaDao
class AddressDaoImpl : HandsomeDao<Address>(), AddressDao
class CartDaoImpl : HandsomeDao<Cart>(), CartDao
class CustomerDaoImpl : HandsomeDao<Customer>(), CustomerDao
class EvaluateDaoImpl : HandsomeDao<Evaluate>(), EvaluateDao
class GoodsCategoryDaoImpl : HandsomeDao<GoodsCategory>(), GoodsCategoryDao
class GoodsDaoImpl : HandsomeDao<Goods>(), GoodsDao
class GoodsImageDaoImpl : HandsomeDao<GoodsImage>(), GoodsImageDao
class OrdersDaoImpl : HandsomeDao<Orders>(), OrdersDao
class OrdersDetailDaoImpl : HandsomeDao<OrdersDetail>(), OrdersDetailDao
class SellerDaoImpl : HandsomeDao<Seller>(), SellerDao
class ShopDaoImpl : HandsomeDao<Shop>(), ShopDao
class AttrNameDaoImpl : HandsomeDao<AttrName>(), AttrNameDao
class AttrValueDaoImpl : HandsomeDao<AttrValue>(), AttrValueDao
class AttrCombDaoImpl : HandsomeDao<AttrComb>(), AttrCombDao {

    /*
    select * from
        (select attrValue from AttrValue where attrName=1)
        cross join
        (select attrValue from AttrValue where attrName=2)
        cross join
        (select attrValue from AttrValue where attrName=3)
     */

    override fun createCombination(goods: Goods, remainCount: Int, price: Double, vararg attrValue: AttrValue): Boolean {
        val lists = ArrangementUtil.arrangementRecursive(listOf(*attrValue))
        var succeed = true
        for (i in 0 until lists.size) {
            val attrValueList = lists[i]
            if (!insert(goods, remainCount + i, price + i, attrValueList)) {
                succeed = false
            }
        }
        return succeed
    }

    @Throws(SQLException::class)
    override fun insert(goods: Goods, remainCount: Int, price: Double, attrValueList: List<AttrValue>): Boolean {
        if (attrValueList.size >= 10) {
            throw SQLException("attribute count >= 10")
        }
        val attrComb = AttrComb(goods, 30.0, 10,
                if (attrValueList.size < 1) null else attrValueList[0],
                if (attrValueList.size < 2) null else attrValueList[1],
                if (attrValueList.size < 3) null else attrValueList[2],
                if (attrValueList.size < 4) null else attrValueList[3],
                if (attrValueList.size < 5) null else attrValueList[4],
                if (attrValueList.size < 6) null else attrValueList[5],
                if (attrValueList.size < 7) null else attrValueList[6],
                if (attrValueList.size < 8) null else attrValueList[7],
                if (attrValueList.size < 9) null else attrValueList[8]
        )
        return insert(attrComb)
    }

    //        categoryDao = new GoodsCategoryDaoImpl();
//        customerDao = new CustomerDaoImpl();
//        sellerDao = new SellerDaoImpl();
//        shopDao = new ShopDaoImpl();
//        goodsDao = new GoodsDaoImpl();
//        goodsImageDao = new GoodsImageDaoImpl();
//        attrNameDao = new AttrNameDaoImpl();
//        attrValueDao = new AttrValueDaoImpl();
//        attrCombDao = new AttrCombDaoImpl();
//        ordersDao = new OrdersDaoImpl();
//        ordersDetailDao = new OrdersDetailDaoImpl();
//        cartDao = new CartDaoImpl();
//        evaluateDao = new EvaluateDaoImpl();
//        areaDao = new AreaDaoImpl();
//        addressDao = new AddressDaoImpl();
}