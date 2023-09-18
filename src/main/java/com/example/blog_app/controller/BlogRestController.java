package com.example.blog_app.controller;

import com.example.blog_app.model.Blog;
import com.example.blog_app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getAll() {
        try {
            List<Blog> blogs = blogService.findAll();
            if (blogs.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
            } else {
                return new ResponseEntity<>(blogs, HttpStatus.OK); // 200
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // lỗi client
        }
    }

    // RequestBody tự động mapping thuộc tính vào thuộc tính của đối tượng
    @PostMapping
    public ResponseEntity<?> save( @RequestBody Blog blog){
         blogService.create(blog);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id){
        Blog blogRest = blogService.findById(id);
        if(blogRest.getId() == 0){
            return new ResponseEntity<>(blogRest,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogRest,HttpStatus.OK);

    }








}
