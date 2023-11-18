package com.ywxx.cineEase.service.payment.state;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.service.OrderInfoService;
import com.ywxx.cineEase.service.impl.OrderInfoServiceImpl;
import com.ywxx.cineEase.utils.type.PayStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuccessPaymentState implements PaymentState {

    @Autowired
    private OrderInfoService orderInfoService;

    @Override
    public Optional<OrderInfo> processPayment(OrderInfo orderInfo) {
        orderInfo.setStatus(PayStatusType.SUCCESS);

        return Optional.of(orderInfoService.createOrderInfo(orderInfo));
    }
}
