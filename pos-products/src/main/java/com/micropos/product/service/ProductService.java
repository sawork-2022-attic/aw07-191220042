package com.micropos.product.service;

import com.micropos.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> products();

    public Optional<Product> getProduct(int id);

    public Product randomProduct();
}
