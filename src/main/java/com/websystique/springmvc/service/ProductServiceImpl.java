package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Product;
import com.websystique.springmvc.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raj on 5/16/16.
 */
public class ProductServiceImpl implements ProductService{
    private static List<Product> products;
    static {
        products = populateDummyProducts();
    }
    public Product findByModelNo(String modelNo) {
        return null;
    }

    public Map<String , Product> findByType(String type) {
        return null;
    }

    public List<Product> findByBrand(String type) {
        return null;
    }

    public void saveProduct(Product product) {
       products.add(product);
    }

    public Product updateProduct(Product product) {
        int index = users.indexOf(user);
        users.set(index, user);
        return null;
    }

    public Product deleteProductByModelNo(String modelNo) {
        return null;
    }

    public List<Product> findAllProducts() {
        return products;
    }

    public void deleteAllProducts() {

    }

    public boolean isProductExist(Product product) {
        return false;
    }

    private static List<Product> populateDummyProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("M101","Telivision", 100L, "tv", "samsung" , 1000.00));
        products.add(new Product("M102","Home Theatre", 200L, "audio", "bose" , 500.00));
        products.add(new Product("M103","Telivision", 200L, "tv", "sony" , 500.00));
        return products;
    }

}
