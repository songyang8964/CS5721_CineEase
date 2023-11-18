package com.ywxx.cineEase.service.impl;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.repository.OrderInfoRepository;
import com.ywxx.cineEase.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private  OrderInfoRepository orderInfoRepository;
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
