package com.handsome.shop.action;

import com.handsome.shop.bean.Customer;
import com.handsome.shop.bean.Goods;
import com.handsome.shop.bean.Orders;
import com.handsome.shop.framework.DaoFactory;
import com.handsome.shop.dao.OrdersDao;
import com.handsome.shop.framework.ActionSupport;
import com.wangrg.java_util.DateUtil;
import com.wangrg.java_util.GsonUtil;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * by wangrongjun on 2017/6/20.
 */
public class CreateOrderAction extends ActionSupport {
    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, CustomerNotExistsException {
        Customer customer = checkCustomer();
        String address = checkStringParameter("address");
        String phone = checkStringParameter("phone");
        String receiverName = checkStringParameter("receiverName");

        Goods goods = (Goods) request.getSession().getAttribute("goods");
        if (goods == null) {
            return "-error_param.jsp";
        }
        int count;
        try {
            count = (int) request.getSession().getAttribute("count");
        } catch (Exception e) {
            return "-error_param.jsp";
        }

        OrdersDao ordersDao = DaoFactory.getOrdersDao();
        customer = new Customer(customer.getCustomerId());
        Orders orders = new Orders(customer, goods, count, count * goods.getPrice(),
                phone, receiverName, address, DateUtil.getCurrentDateAndTime(), Orders.STATE_CONTINUE);
        ordersDao.insert(orders);

        // TODO 成功添加订单后，address_list,goods,count等变量就没必要了，可以清除
        request.getSession().removeAttribute("address_list");
        request.getSession().removeAttribute("goods");
        request.getSession().removeAttribute("count");

        request.getSession().setAttribute("orders", orders);
        GsonUtil.printFormatJson(orders);
        return "-create_order_succeed.jsp";
    }
}
