package com.ywxx.cineEase.service.impl;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.entity.Seat;
import com.ywxx.cineEase.repository.SeatRepository;
import com.ywxx.cineEase.repository.TicketRepository;
import com.ywxx.cineEase.service.BookingService;
import com.ywxx.cineEase.service.OrderInfoService;
import com.ywxx.cineEase.service.payment.state.PaymentContext;
import com.ywxx.cineEase.service.payment.method.PaymentMethod;
import com.ywxx.cineEase.service.payment.method.PaymentMethodFactory;
import com.ywxx.cineEase.service.payment.state.CancelPaymentState;
import com.ywxx.cineEase.service.payment.state.PendingPaymentState;
import com.ywxx.cineEase.utils.type.PayMethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private  OrderInfoService orderInfoService;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private PaymentContext paymentContext;
    @Autowired
    private PendingPaymentState pendingPaymentState;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private PaymentMethodFactory paymentMethodFactory;
    @Autowired
    private CancelPaymentState cancelPaymentState;

    private List<BookingService> bookings = new ArrayList<>();

    public void addBooking(BookingService booking) {
        bookings.add(booking);
    }
    @Override
    public void booking(Long ticketId, Long userId, PayMethodType payMethod) {
        // do something before paying

        // todo 3, get user membership, get user's discount, get final amount that user should pay.

        // there are the implementation of step 4

        // 1, Create a new OrderInfo, and instantiate the context with a default state
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setPayMethod(payMethod);
        Date date = new Date();
        orderInfo.setCreateOn(date);
        orderInfo.setUserId(userId);
        orderInfo.setTicketId(ticketId);

        paymentContext.setPaymentState(pendingPaymentState);

        OrderInfo newOrderInfo = paymentContext.processPayment(orderInfo).get();

        // 2, according to the payment method the user choose, process payment
        PaymentMethod paymentMethod = paymentMethodFactory.createPaymentMethod(payMethod);
        paymentMethod.processPayment(newOrderInfo);
    }

    @Override
    public String cancel(Long orderInfoId) {
        String failPage = "http://xxxxx/failpage";
        String SuccessPage = "http://xxxxx/successPage";

        // step 1 according to orderInfoId, get payment method
        Optional<OrderInfo> orderInfo = orderInfoService.getOrderInfoById(orderInfoId);

        if(orderInfo.isEmpty()) {
            return failPage;
        }else {
            // step 2 cancel order
            paymentContext.setPaymentState(cancelPaymentState);

            Optional<OrderInfo> newOrderInfo = paymentContext.processPayment(orderInfo.get());

            // step 3 according to the cancel status from third-party platform, update movie's seat status
            if(newOrderInfo.isPresent()) {
                // update movie's seat status here.
                Long ticketId = newOrderInfo.get().getTicketId();
                Long seatId = ticketRepository.findById(ticketId).get().getSeatId();
                Seat seat = seatRepository.findById(seatId).get();
                seat.setAvailable(true);
                seatRepository.save(seat);

            }

            // step 4 return redirect page
            return SuccessPage;
        }

    }

    @Override
    public void show() {
        for (BookingService booking : bookings) {
            booking.show();
        }
    }


}
