package com.example.blog_app.controller;

import com.example.blog_app.model.ECommerce;
import com.example.blog_app.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/ecommerce")
public class ECommerceRestController {
    @Autowired
    private ECommerceService eCommerceService;

    @GetMapping
    public ResponseEntity<List<ECommerce>> getAllEcommmerce(){
        List<ECommerce> eCommerceList = eCommerceService.findAll();
        if(eCommerceList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(eCommerceList,HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ECommerce> getByIdEcommerce(@PathVariable int id){
        ECommerce eCommerce = eCommerceService.findById(id);
        if(eCommerce.getId() == 0){
            return new ResponseEntity<>(eCommerce,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(eCommerce,HttpStatus.OK);
    }


}
