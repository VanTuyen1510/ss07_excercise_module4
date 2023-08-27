package com.example.blog_app.service;

import com.example.blog_app.model.ECommerce;

import java.util.List;

public interface ECommerceService {
  ECommerce findById(int id);
  List<ECommerce> findAll();
}
