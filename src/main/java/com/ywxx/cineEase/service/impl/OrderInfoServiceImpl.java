package com.ywxx.cineEase.service.impl;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.repository.OrderInfoRepository;
import com.ywxx.cineEase.service.OrderInfoService;

import java.util.Optional;

public class OrderInfoServiceImpl implements OrderInfoService {
    private final OrderInfoRepository orderInfoRepository;

    public OrderInfoServiceImpl(OrderInfoRepository orderInfoRepository) {
        this.orderInfoRepository = orderInfoRepository;
    }

    @Override
    public OrderInfo updateOrderStatus(long orderId, Boolean status) {
        return null;
    }

    @Override
    public OrderInfo createOrderInfo(OrderInfo orderInfo) {
        return orderInfoRepository.save(orderInfo);
    }
    @Override
    public OrderInfo updateOrderInfo(OrderInfo orderInfo) {
        return orderInfoRepository.save(orderInfo);
    }
    @Override
    public Optional<OrderInfo> getOrderInfoById(Long id) {
        return orderInfoRepository.findById(id);
    }
}
