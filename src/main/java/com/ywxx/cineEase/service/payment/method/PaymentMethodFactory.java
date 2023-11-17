package com.ywxx.cineEase.service.payment.method;

import com.ywxx.cineEase.utils.type.PayMethodType;

public class PaymentMethodFactory {

    private CardInfo cardInfo;
    public PaymentMethodFactory() {}

    public PaymentMethodFactory(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public PaymentMethod createPaymentMethod(PayMethodType paymentType) {
        if(paymentType == PayMethodType.GOOGLEPAY) {
            return new GooglePayment();
        }else if (paymentType == PayMethodType.CARD) {
            return new CardPayment(cardInfo);
        } else if (paymentType == PayMethodType.PAYPAL) {
            return new PaypalPayment();
        } else {
            throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
    }
}
