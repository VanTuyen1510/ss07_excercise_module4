package com.example.blog_app.service;

import com.example.blog_app.model.Blog;
import com.example.blog_app.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id){
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllBlogByName(String name, Pageable pageable) {
        return blogRepository.findBlogByAuthorContaining(name,pageable);
    }

    @Override
    public Page<Blog> findAllBlogByECommerceId(int id, Pageable pageable) {
        return blogRepository.findAllBlogByECommerceId(id,pageable);
    }

    @Override
    public List<Blog> findByAuthor(String author) {
        return blogRepository.findAllByAuthorContaining(author);
    }
}
