package com.example.blog_app.controller;

import com.example.blog_app.model.Blog;
import com.example.blog_app.service.BlogService;
import com.example.blog_app.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    ECommerceService eCommerceService;

    @GetMapping("")
    public String displayBlog(){
        return "list";
    }

    // isPresent nếu có giá trị trả về true còn rỗng trả về false
    // Optional có tác dụng tương tự OrElse
    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("ecommerces", eCommerceService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog) {
        blogService.create(blog);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String viewUpdate(@RequestParam("id") int id , Model model){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("ecommerces", eCommerceService.findAll());
        return "update";
    }
    @PostMapping("/update")
    public String doUpdate(Blog blog){
        blogService.update(blog);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String doDelete(@RequestParam("id") int id , Model model){
        blogService.delete(id);
        model.addAttribute("blog",eCommerceService.findAll());
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String viewDetail(Model model , @RequestParam("id") int id){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }

}
