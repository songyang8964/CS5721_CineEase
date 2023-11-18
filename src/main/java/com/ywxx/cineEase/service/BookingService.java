package com.ywxx.cineEase.service;

import com.ywxx.cineEase.utils.type.PayMethodType;

public interface BookingService {
    void booking(Long ticketId, Long userId, PayMethodType payMethod);

    String cancel(Long orderInfoId);

}
