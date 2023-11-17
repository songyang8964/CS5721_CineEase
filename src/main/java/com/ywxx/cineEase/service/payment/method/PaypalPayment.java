package com.ywxx.cineEase.service.payment.method;

import com.ywxx.cineEase.utils.type.PayResult;

public class PaypalPayment implements PaymentMethod{
    @Override
    public PayResult processPayment() {
        return PayResult.FAIL;
    }
}
