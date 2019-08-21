package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping(path ="/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 查询所有信息
     */
    @RequestMapping(path ="/findAll")
//    @RolesAllowed("ADMIN")
    public String findAll(Model model, @RequestParam(name = "pageNo",defaultValue = "1") Integer pageNo,@RequestParam(name = "rows",defaultValue = "5") Integer rows){
        //查询所有商品数据
        List<Product> products = productService.findAll(pageNo, rows);
        //创建分页对象
        PageInfo<Product> productPageInfo = new PageInfo<Product>(products);
        //存储数据到model
        model.addAttribute("productPageInfo",productPageInfo);
        return "product-list";
    }

    /**
     * 添加数据
     */
    @RequestMapping(path = "/add")
    public String add(Product product){
        // 调用业务层完成添加操作
        productService.add(product);
        //重定向 页面跳转到查询所有订单
        return "redirect:/product/findAll";
    }
}
