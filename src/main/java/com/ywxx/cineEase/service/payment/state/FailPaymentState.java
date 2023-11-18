package com.ywxx.cineEase.service.payment.state;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.service.OrderInfoService;
import com.ywxx.cineEase.utils.type.PayStatusType;
import com.ywxx.cineEase.utils.type.StateHandleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FailPaymentState implements PaymentState {
    @Autowired
    private OrderInfoService orderInfoService;

    public FailPaymentState() {}
    @Override
    public Optional<OrderInfo> processPayment(OrderInfo orderInfo) {
        orderInfo.setStatus(PayStatusType.FAIL);
        return Optional.of(orderInfoService.createOrderInfo(orderInfo));
    }
}
