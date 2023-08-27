package com.example.blog_app.service;

import com.example.blog_app.model.ECommerce;
import com.example.blog_app.repository.ECommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ECommerceServiceImpl implements ECommerceService{
    @Autowired
    ECommerceRepository repository;
    @Override
    public ECommerce findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ECommerce> findAll() {
        return repository.findAll();
    }
}
