package com.ywxx.cineEase.service;

import com.ywxx.cineEase.entity.OrderInfo;

import java.util.Optional;

public interface OrderInfoService {

    OrderInfo updateOrderStatus(long orderId, Boolean status);

    OrderInfo createOrderInfo(OrderInfo orderInfo);

    OrderInfo updateOrderInfo(OrderInfo orderInfo);

    Optional<OrderInfo> getOrderInfoById(Long id);
}
