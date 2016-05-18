package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Product;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

/**
 * Created by RJK on 5/17/2016.
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Product>> listAllUsers() {
        Map<String, Product> products = productService.findAllProducts();
        if(products.isEmpty()){
            return new ResponseEntity<Map<String, Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Map<String, Product>>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{modelNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("modelNo") String modelNo) {
        System.out.println("Fetching Product with model number " + modelNo);
        Product product = productService.findByModelNo(modelNo);
        if (product == null) {
            System.out.println("Product with model number " + modelNo + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }


    //-------------------Create a User--------------------------------------------------------

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Product " + product.getModelNo());

        if (productService.isProductExist(product)) {
            System.out.println("A Product with model number " + product.getModelNo() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        productService.saveProduct(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getModelNo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //------------------- Update a User --------------------------------------------------------

    @RequestMapping(value = "/product/{modelNo}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateUser(@PathVariable("modelNo") String modelNo, @RequestBody Product product) {
        System.out.println("Updating Product " + modelNo);

        Product currentProduct = productService.findByModelNo(modelNo);

        if (currentProduct==null) {
            System.out.println("Product with model number" + modelNo + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
/*
        currentProduct.setUsername(user.getUsername());
        currentProduct.setAddress(user.getAddress());
        currentProduct.setEmail(user.getEmail());
*/
        productService.updateProduct(product);
        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    }



    //------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/product/{modelNo}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteUser(@PathVariable("modelNo") String modelNo) {
        System.out.println("Fetching & Deleting Product with model number " + modelNo);

        Product product = productService.findByModelNo(modelNo);
        if (product == null) {
            System.out.println("Unable to delete. Product with model number " + modelNo + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        productService.deleteProductByModelNo(modelNo);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }


}
