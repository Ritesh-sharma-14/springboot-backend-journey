package com.example.product.dao;

import java.util.List;
import com.example.product.model.Product;

public interface ProductDAO {
    int addProduct(Product product);
    int updateProduct(Product product);
    int deleteProduct(int id);
    Product getProductById(int id);
    List<Product> getAllProducts();
}

