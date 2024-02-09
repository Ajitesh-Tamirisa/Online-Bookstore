package com.example.masterRobot.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="comic_books")
public class ComicBooks {
    @Id
    @Column(name = "item_id", nullable = false)
    private Long item_id;

    @Column(name="title")
    private String title;
    @Column(name="published_date")
    private Date published_date;

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public ComicBooks() {
    }

    public ComicBooks(long item_id, String title, Date published_date) {
        this.item_id = item_id;
        this.title = title;
        this.published_date = published_date;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }

    @Override
    public String toString() {
        return "ComicBooks{" +
                "item_id=" + item_id +
                ", title='" + title + '\'' +
                ", published_date=" + published_date +
                '}';
    }
}
