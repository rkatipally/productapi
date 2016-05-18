package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Product;
import com.websystique.springmvc.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 5/16/16.
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
    private static Map<String , Product> products;
    static {
        products = populateDummyProducts();
    }
    public Product findByModelNo(String modelNo) {
        return products.get(modelNo);
    }

    public Map<String , Product> findByType(String type) {
        return null;
    }

    public Map<String,Product> findByBrand(String type) {
        return null;
    }

    public void saveProduct(Product product) {
       products.put(product.getModelNo(), product);
    }

    public String  updateProduct(Product product) {
        System.out.println("description :" + product.getDescription());
        products.put(product.getModelNo(), product);
        return product.getModelNo();
    }

    public Product deleteProductByModelNo(String modelNo) {
        return products.remove(modelNo);
    }

    public Map<String , Product> findAllProducts() {
        return products;
    }

    public void deleteAllProducts() {

    }

    public boolean isProductExist(Product product) {
        return false;
    }

    private static Map<String , Product> populateDummyProducts(){
        Map<String , Product> products = new HashMap<String , Product>();
        products.put("M101",new Product("M101","Telivision", 100L, "tv", "1" , 1000.00));
        products.put("M102",new Product("M102","Home Theatre", 200L, "speaker", "2" , 500.00));
        products.put("M103",new Product("M103","Telivision", 200L, "tv", "2" , 500.00));
        return products;
    }

}
