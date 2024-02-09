package com.example.masterRobot.entity;

import javax.persistence.*;

@Entity
@Table(name="payment_details")
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id", nullable = false)
    private Long payment_id;

    private float tax;
    private float discount;
    private float total;
    private float grandTotal;
    private long orderId;

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public PaymentDetails() {
    }

    public PaymentDetails(Long payment_id, float tax, float discount, float total, float grandTotal, long orderId) {
        this.payment_id = payment_id;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
        this.grandTotal = grandTotal;
        this.orderId = orderId;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(float grandTotal) {
        this.grandTotal = grandTotal;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
