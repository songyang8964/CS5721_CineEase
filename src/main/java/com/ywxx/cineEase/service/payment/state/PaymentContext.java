package com.ywxx.cineEase.service.payment.state;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.service.payment.state.PaymentState;
import com.ywxx.cineEase.utils.type.StateHandleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentContext {
    private PaymentState paymentState;

    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    public Optional<OrderInfo> processPayment(OrderInfo orderInfo) {
        return paymentState.processPayment(orderInfo);
    }
}
