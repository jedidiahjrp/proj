package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private final ProductService svc;
    public ProductController(ProductService svc){this.svc=svc;}

    @GetMapping("/")
    public String list(Model m){
        m.addAttribute("products", svc.listAll());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable Long id, Model m){
        m.addAttribute("product", svc.get(id));
        return "product";
    }

    @GetMapping("/admin/add")
    public String addForm(Model m){
        m.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/admin/add")
    public String addSubmit(@ModelAttribute Product product){
        svc.save(product);
        return "redirect:/";
    }
}
