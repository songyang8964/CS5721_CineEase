package com.ywxx.cineEase.service.payment.method;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.service.payment.state.PaymentContext;
import com.ywxx.cineEase.service.payment.state.SuccessPaymentState;
import com.ywxx.cineEase.utils.type.PayResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GooglePayment implements PaymentMethod{
    @Autowired
    private PaymentContext paymentContext;
    @Autowired
    private SuccessPaymentState successPaymentState;

    @Override
    public PayResult processPayment(OrderInfo orderInfo) {
        // todo Integrate with Google Pay API to handle payment
        // todo Include logic for interacting with the Google Pay API, such as creating a payment request, handling responses, etc.

        // get payment result from third-party platform
        String result = "success";
        if(result.equals("success")) {
            // set orderInfo
            paymentContext.setPaymentState(successPaymentState);

            Optional<OrderInfo> newOrderInfo = paymentContext.processPayment(orderInfo);
            if(newOrderInfo.isEmpty()) {
                return PayResult.FAIL;
            }else {
                return PayResult.SUCCESS;
            }
        }

        return PayResult.FAIL;
    }
}
