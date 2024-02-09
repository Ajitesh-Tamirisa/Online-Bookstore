package com.example.masterRobot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="order_line_items")
public class OrderLineItems implements Serializable {
    @Id
    @Column(name = "line_id", nullable = false)
    private long lineId;

    @Column(name = "item_id")
    private long itemId;
    @Id
    @Column(name = "order_id", nullable = false)
    private long orderId;

    @Column(name = "quantity")
    private long quantity;

    public OrderLineItems() {
    }

    public OrderLineItems(long lineId, long itemId, long orderId, long quantity) {
        this.lineId = lineId;
        this.itemId = itemId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public long getLineId() {
        return lineId;
    }

    public void setLineId(long lineId) {
        this.lineId = lineId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
