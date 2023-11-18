package com.ywxx.cineEase.service.payment.state;

import com.ywxx.cineEase.entity.OrderInfo;
import com.ywxx.cineEase.repository.OrderInfoRepository;
import com.ywxx.cineEase.service.OrderInfoService;
import com.ywxx.cineEase.utils.type.PayStatusType;
import com.ywxx.cineEase.utils.type.StateHandleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CancelPaymentState implements PaymentState {
    @Autowired
    private OrderInfoService orderInfoService;

    public CancelPaymentState() {}

    @Override
    public Optional<OrderInfo> processPayment(OrderInfo orderInfo) {
        // todo according to different way of payment, return user's money in different way.

        // after cancelling, get status from third-party platform, if success, change orderInfo status into cancel.
        orderInfo.setStatus(PayStatusType.CANCEL);
        return Optional.of(orderInfoService.updateOrderInfo(orderInfo));
    }
}
