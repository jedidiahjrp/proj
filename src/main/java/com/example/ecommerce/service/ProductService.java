package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo){this.repo=repo;}
    public List<Product> listAll(){ return repo.findAll(); }
    public Product get(Long id){ return repo.findById(id).orElse(null); }
    public Product save(Product p){ return repo.save(p); }
}
