package com.wei.springbootmall2.Dao;

import com.wei.springbootmall2.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
