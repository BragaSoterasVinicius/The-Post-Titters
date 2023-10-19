package com.postitters.postitters.posts.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "POSTAGEMDATA")
    private LocalDateTime dateTime;
    @Column(name = "TEXTCONTENT")
    private String text_content;
    @Column(name = "IMAGECONTENT")
    private String image_url;
    @Column(name = "ARROBA")
    private String arroba;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getArroba() {
        return arroba;
    }

    public void setArroba(String arroba) {
        this.arroba = arroba;
    }

}
