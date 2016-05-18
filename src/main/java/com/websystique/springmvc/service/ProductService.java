package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Product;
import com.websystique.springmvc.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 5/16/16.
 */

public interface ProductService {
    Product findByModelNo(String modelNo);

    Map<String,Product> findByType(String type);

    Map<String,Product> findByBrand(String type);

    void saveProduct(Product product);

    String updateProduct(Product product);

    Product deleteProductByModelNo(String modelNo);

    Map<String,Product> findAllProducts();

    void deleteAllProducts();

    public boolean isProductExist(Product product);
}
