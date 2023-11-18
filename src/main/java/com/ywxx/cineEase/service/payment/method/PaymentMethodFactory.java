package com.ywxx.cineEase.service.payment.method;

import com.ywxx.cineEase.utils.type.PayMethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodFactory {
    @Autowired
    private GooglePayment googlePayment;
    @Autowired
    private CardPayment cardPayment;
    @Autowired
    private PaypalPayment paypalPayment;

    private CardInfo cardInfo;
    public PaymentMethodFactory() {}


    public PaymentMethod createPaymentMethod(PayMethodType paymentType) {
        if(paymentType == PayMethodType.GOOGLEPAY) {
            return googlePayment;
        }else if (paymentType == PayMethodType.CARD) {
            return cardPayment;
        } else if (paymentType == PayMethodType.PAYPAL) {
            return paypalPayment;
        } else {
            throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
    }
}
