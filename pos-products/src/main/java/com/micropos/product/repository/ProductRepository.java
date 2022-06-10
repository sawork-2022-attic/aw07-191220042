package com.micropos.product.repository;


import com.micropos.product.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

//    public List<Product> allProducts();
//
//    public Product findProduct(String productId);

}