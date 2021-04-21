package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
 @RestController
 @Slf4j

public class ProductController
{

    private ProductServiceImpl servicee;
    @Autowired
    public ProductController(ProductServiceImpl servicee) {
        this.servicee = servicee;
    }

    @RequestMapping("/api/informationList/list")
    public List<Product> informationList()
    {
        log.info("get Information list");
        List<Product> productInfo= new ArrayList<Product>();

        productInfo= servicee.findAll();
        return productInfo;
    }


}
