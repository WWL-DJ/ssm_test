package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import com.itheima.dao.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll(Integer pageNo,Integer rows) {
        //开启分页查询
        PageHelper.startPage(pageNo,rows);
        //返回查询数据集合
        return productMapper.findAll(pageNo,rows);
    }

    @Override
    public void add(Product product) {
        productMapper.add(product);
    }
}
