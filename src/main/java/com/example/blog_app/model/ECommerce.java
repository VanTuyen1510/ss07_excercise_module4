package com.example.blog_app.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ECommerce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "eCommerce") //mappedBy kiểu như liên kết khóa ngoại,bên 1 là oneToMany còn bên nhiều là ManyToOne
    List<Blog> blogs;

    public ECommerce() {
    }

    public ECommerce(int id, String name, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
