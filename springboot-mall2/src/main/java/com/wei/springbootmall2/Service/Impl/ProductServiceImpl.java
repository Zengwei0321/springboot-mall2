package com.wei.springbootmall2.Service.Impl;

import com.wei.springbootmall2.Dao.ProductDao;
import com.wei.springbootmall2.Service.ProductService;
import com.wei.springbootmall2.dto.ProductRequest;
import com.wei.springbootmall2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.PrintService;

@Component

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }
}
