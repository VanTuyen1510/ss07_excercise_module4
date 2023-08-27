package com.example.blog_app.service;

import com.example.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    Blog findById(int id);

    void create(Blog blog);

    void update(Blog blog);

    void delete(int id);

    Page<Blog> findAllBlog(Pageable pageable);

    Page<Blog> findAllBlogByName(String name,Pageable pageable);

    Page<Blog> findAllBlogByECommerceId(int id, Pageable pageable);
}
