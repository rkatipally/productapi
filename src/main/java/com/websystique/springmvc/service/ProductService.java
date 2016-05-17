package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Product;
import com.websystique.springmvc.model.User;

import java.util.List;

/**
 * Created by raj on 5/16/16.
 */
public interface ProductService {
    Product findByModelNo(String modelNo);

    List<Product> findByType(String type);

    List<Product> findByBrand(String type);

    void saveProduct(Product product);

    Product updateProduct(Product product);

    Product deleteProductByModelNo(String modelNo);

    List<Product> findAllProducts();

    void deleteAllProducts();

    public boolean isProductExist(Product product);
}
