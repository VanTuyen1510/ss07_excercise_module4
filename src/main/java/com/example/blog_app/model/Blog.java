package com.example.blog_app.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String topic;

    private String author;


    @ManyToOne(targetEntity = ECommerce.class) // trỏ tới đối tượng muốn liên kết
    // 1 EComerce có nhiều blog,1 blog được tạo ra bởi 1 ECommerce
        private ECommerce eCommerce;

    public Blog() {
    }

    public Blog(int id, String topic, String author, ECommerce eCommerce) {
        this.id = id;
        this.topic = topic;
        this.author = author;
        this.eCommerce = eCommerce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ECommerce geteCommerce() {
        return eCommerce;
    }

    public void seteCommerce(ECommerce eCommerce) {
        this.eCommerce = eCommerce;
    }
}
