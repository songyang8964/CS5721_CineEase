package com.ywxx.cineEase.service;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.service.payment.PaymentContext;
import com.ywxx.cineEase.service.payment.method.PaymentMethod;
import com.ywxx.cineEase.service.payment.method.PaymentMethodFactory;
import com.ywxx.cineEase.service.payment.state.CancelPaymentState;
import com.ywxx.cineEase.service.payment.state.PendingPaymentState;
import com.ywxx.cineEase.utils.type.PayMethodType;

import java.util.Date;
import java.util.Optional;

public class BookingService {
    private final OrderInfoService orderInfoService;

    public BookingService(OrderInfoService orderInfoService) {
        this.orderInfoService = orderInfoService;
    }


    public void booking(Long ticketId, Long userId, PayMethodType payMethod) {
        // do something before paying
        // todo 1, check ticket is valid
        // todo 2, if valid, lock the ticket
        // todo 3, get user membership, get user's discount, get final amount that user should pay.
        // 4, according to the payment method the user choose, process payment
        // todo 5, according to the payment state, update database, for example, Ticket status.


        // there are the implementation of step 4

        // 1, Create a new OrderInfo, and instantiate the context with a default state
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setPayMethod(payMethod);
        Date date = new Date();
        orderInfo.setCreateOn(date);
        orderInfo.setUserId(userId);
        orderInfo.setTicketId(ticketId);

        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPaymentState(new PendingPaymentState());

        OrderInfo newOrderInfo = paymentContext.processPayment(orderInfo).get();

        // 2, according to the payment method the user choose, process payment
        PaymentMethodFactory paymentMethodFactory = new PaymentMethodFactory();
        PaymentMethod paymentMethod = paymentMethodFactory.createPaymentMethod(payMethod);
        paymentMethod.processPayment(newOrderInfo);
    }


    public String cancel(Long orderInfoId) {
        String failPage = "http://xxxxx/failpage";
        String SuccessPage = "http://xxxxx/successPage";

        // step 1 according to orderInfoId, get payment method
        Optional<OrderInfo> orderInfo = orderInfoService.getOrderInfoById(orderInfoId);

        if(orderInfo.isEmpty()) {
            return failPage;
        }else {
            // step 2 cancel order
            PaymentContext paymentContext = new PaymentContext();
            paymentContext.setPaymentState(new CancelPaymentState());

            Optional<OrderInfo> newOrderInfo = paymentContext.processPayment(orderInfo.get());

            // step 3 according to the cancel status from third-party platform, update movie's seat status
            if(newOrderInfo.isPresent()) {
                // todo update movie's seat status here.
            }

            // step 4 return redirect page
            return SuccessPage;
        }

    }
}
