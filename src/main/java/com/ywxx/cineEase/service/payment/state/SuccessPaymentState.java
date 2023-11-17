package com.ywxx.cineEase.service.payment.state;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.service.OrderInfoService;
import com.ywxx.cineEase.utils.type.PayStatusType;
import com.ywxx.cineEase.utils.type.StateHandleResult;

import java.util.Optional;

public class SuccessPaymentState implements PaymentState {
    private OrderInfoService orderInfoService;

    public SuccessPaymentState() {}
    @Override
    public Optional<OrderInfo> processPayment(OrderInfo orderInfo) {
        orderInfo.setStatus(PayStatusType.SUCCESS);
        return Optional.of(orderInfoService.createOrderInfo(orderInfo));
    }
}
