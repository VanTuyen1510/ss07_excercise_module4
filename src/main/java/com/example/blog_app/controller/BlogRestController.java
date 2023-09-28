package com.example.blog_app.controller;

import com.example.blog_app.model.Blog;
import com.example.blog_app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public ResponseEntity<?> save(@RequestBody Blog blog){
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

    @GetMapping("/search")
    private ResponseEntity<List<Blog>> searchByAuthor(@RequestParam("author") String author ){
       return new ResponseEntity<>(blogService.findByAuthor(author),HttpStatus.OK);
    }
   @GetMapping("/load-page")
   public ResponseEntity<Page<Blog>> loading(@RequestParam(defaultValue = "0",required = false) int page){
       Pageable pageable = PageRequest.of(page, 5);
       Page<Blog> blogs = blogService.findAllBlog(pageable);
       return new ResponseEntity<>(blogs,HttpStatus.OK);
   }
//   @GetMapping("/load")
//    public ResponseEntity<Page<Blog>> loadMoreBlog(@RequestParam(defaultValue = "0",required = false) int trang){
//
//           Pageable pageable = PageRequest.of(trang, 5);
//           Page<Blog> blogs = blogService.findAllBlog(pageable);
////           model.addAttribute("blogs", blogs);
////           int totalPage = blogs.getTotalPages();
////           if (totalPage > 1) {
////               List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
////                       .boxed()
////                       .collect(Collectors.toList());
////               model.addAttribute("pageNumbers", pageNumbers);
////           }
//           return new ResponseEntity<>(blogs,HttpStatus.OK);

//   }








}
