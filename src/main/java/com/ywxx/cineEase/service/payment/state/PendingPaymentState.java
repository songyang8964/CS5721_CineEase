package com.ywxx.cineEase.service.payment.state;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.service.OrderInfoService;
import com.ywxx.cineEase.utils.type.PayStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PendingPaymentState implements PaymentState {

    @Autowired
    private OrderInfoService orderInfoService;

    @Override
    public Optional<OrderInfo> processPayment(OrderInfo orderInfo) {
        orderInfo.setStatus(PayStatusType.PENDING);
        return Optional.of(orderInfoService.createOrderInfo(orderInfo));
    }
}
