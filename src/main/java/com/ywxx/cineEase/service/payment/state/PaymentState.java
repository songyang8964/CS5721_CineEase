package com.ywxx.cineEase.service.payment.state;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.utils.type.StateHandleResult;

import java.util.Optional;

public interface PaymentState {

    Optional<OrderInfo> processPayment(OrderInfo orderInfo);
}
