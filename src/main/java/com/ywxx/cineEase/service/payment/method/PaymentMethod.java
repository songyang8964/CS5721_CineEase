package com.ywxx.cineEase.service.payment.method;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.utils.type.PayResult;

public interface PaymentMethod {

    PayResult processPayment(OrderInfo orderInfo);
}
