package com.example.masterRobot.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cart_items")
public class CartItem implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
            @Column(name="cart_item_id", nullable = false)
    long cart_item_id;
    @Column(name="cust_id")
    long cust_id;
    @Column(name="item_id")
    long item_id;
    @Column(name="quantity")
    long quantity;
    @Column(name="price")
    long price;
    @Column(name="tax")
    double tax;
    @Column(name="total")
    double total;
//    <th>Item ID</th>
//            <th>Title</th>
//            <th>Quantity</th>
//    <th>Price per unit</th>
//    <th>Tax(10%)</th>
//            <th>Total</th>

    public long getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(long cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public long getQuantity(){
        return this.quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
