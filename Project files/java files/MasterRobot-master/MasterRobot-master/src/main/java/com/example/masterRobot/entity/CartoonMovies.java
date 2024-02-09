package com.example.masterRobot.entity;

import javax.persistence.*;

@Entity
@Table(name="cartoon_movies")
public class CartoonMovies {
    @Id
    @Column(name = "item_id", nullable = false)
    private long itemId;
    @Column(name = "title")
    private String title;

    @Column(name = "studio_name")
    private String studioName;

    @Column(name = "description")
    private String description;

    public CartoonMovies() {
    }

    public CartoonMovies(long itemId, String title, String studioName, String description) {
        this.itemId = itemId;
        this.title = title;
        this.studioName = studioName;
        this.description = description;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CartoonMovies{" +
                "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", stuioName='" + studioName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
