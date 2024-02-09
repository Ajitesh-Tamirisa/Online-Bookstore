package com.example.masterRobot.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="cust_order")
public class CustOrder {
    @Id
    @Column(name = "order_id", nullable = false)
    private long orderId;
    private long custId;
    @Temporal(TemporalType.DATE)
    private Date dateOfOrder;
    @Temporal(TemporalType.DATE)
    private Date shippedDate;
    private long shippingFee;
    @Column(name="number_of_orderlineitems")
    private long numberOfOrderLineItems;

    public CustOrder() {
    }

    public CustOrder(long orderId, long custId, Date dateOfOrder, Date shippedDate, long shippingFee, long numberOfOrderLineItems) {
        this.orderId = orderId;
        this.custId = custId;
        this.dateOfOrder = dateOfOrder;
        this.shippedDate = shippedDate;
        this.shippingFee = shippingFee;
        this.numberOfOrderLineItems = numberOfOrderLineItems;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public long getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(long shippingFee) {
        this.shippingFee = shippingFee;
    }
}
