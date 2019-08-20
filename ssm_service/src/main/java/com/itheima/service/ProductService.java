package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {


    public List<Product> findAll(Integer pageNo,Integer rows);

    public void add(Product product);
}
