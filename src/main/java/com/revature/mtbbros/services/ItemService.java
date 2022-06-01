package com.revature.mtbbros.services;

import com.revature.mtbbros.daos.ProductDAO;
import com.revature.mtbbros.models.Product;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public void register(Product product){
        productDAO.save(product);
    }

}
