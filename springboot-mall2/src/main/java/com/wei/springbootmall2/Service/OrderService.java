package com.wei.springbootmall2.Service;

import com.wei.springbootmall2.dto.CreateOrderRequest;
import com.wei.springbootmall2.model.Order;

public interface OrderService {
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
