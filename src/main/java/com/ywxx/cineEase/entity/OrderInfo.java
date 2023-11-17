package com.ywxx.cineEase.entity;

import com.ywxx.cineEase.service.payment.method.PaymentMethod;
import com.ywxx.cineEase.utils.type.PayStatusType;
import jakarta.persistence.*;
import com.ywxx.cineEase.utils.type.PayMethodType;

import java.util.Date;



public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PayStatusType status;
    @Column(name = "create_on")
    private Date createOn;
    @Column(name = "ticket_id")
    private long ticketId;
    @Column(name = "amount")
    private float amount;
    @Column(name = "user_id")
    private long userId;
    @Enumerated(EnumType.STRING)
    @Column(name="pay_method")
    private PayMethodType payMethod;

    public OrderInfo() {

    }

    public OrderInfo(Long id, PayStatusType status, Date createOn, long ticketId, float amount, long userId, PayMethodType payMethod) {
        this.id = id;
        this.status = status;
        this.createOn = createOn;
        this.ticketId = ticketId;
        this.amount = amount;
        this.userId = userId;
        this.payMethod = payMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PayStatusType getStatus() {
        return status;
    }

    public void setStatus(PayStatusType status) {
        this.status = status;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public PayMethodType getPayMethod() { return payMethod; }

    public void setPayMethod(PayMethodType payMethod) { this.payMethod = payMethod; }

}
