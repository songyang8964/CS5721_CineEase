package com.ywxx.cineEase.service.payment.method;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.service.payment.PaymentContext;
import com.ywxx.cineEase.service.payment.state.PendingPaymentState;
import com.ywxx.cineEase.service.payment.state.SuccessPaymentState;
import com.ywxx.cineEase.utils.type.PayResult;

import java.util.Optional;

public class GooglePayment implements PaymentMethod{
    @Override
    public PayResult processPayment(OrderInfo orderInfo) {
        // todo Integrate with Google Pay API to handle payment
        // todo Include logic for interacting with the Google Pay API, such as creating a payment request, handling responses, etc.

        // get payment result from third-party platform
        String result = "success";
        if(result.equals("success")) {
            // set orderInfo
            PaymentContext paymentContext = new PaymentContext();
            paymentContext.setPaymentState(new SuccessPaymentState());

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
