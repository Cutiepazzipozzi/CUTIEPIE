package jpa.practice.controller;

import jpa.practice.product.Product;
import jpa.practice.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController2 {

    private final ProductService productService;

    @ResponseBody
    @RequestMapping("/products/list")
    public List<Product> list() {
        List<Product> lists = productService.findAll();

        return lists;
    }
}