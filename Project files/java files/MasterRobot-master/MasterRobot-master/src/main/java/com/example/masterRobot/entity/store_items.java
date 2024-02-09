package com.example.masterRobot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="store_items")
public class store_items {
    @Id
    private long item_id;
    private long price;
    private int number_of_copies;

    public store_items() {
    }

    public store_items(int item_id, long price, int number_of_copies) {
        this.item_id = item_id;
        this.price = price;
        this.number_of_copies = number_of_copies;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getNumber_of_copies() {
        return number_of_copies;
    }

    public void setNumber_of_copies(int number_of_copies) {
        this.number_of_copies = number_of_copies;
    }

    @Override
    public String toString() {
        return "store_items{" +
                "item_id=" + item_id +
                ", price=" + price +
                ", number_of_copies=" + number_of_copies +
                '}';
    }
}
