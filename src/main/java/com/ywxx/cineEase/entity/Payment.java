package com.ywxx.cineEase.entity;

import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "discount_coupon_id")
    private Integer discountCouponId;

    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "payment_method")
    private Integer paymentMethod;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Booking booking;


}

