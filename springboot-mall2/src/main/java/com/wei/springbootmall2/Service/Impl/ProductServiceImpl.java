package com.wei.springbootmall2.Service.Impl;

import com.wei.springbootmall2.Constant.ProductCategory;
import com.wei.springbootmall2.Dao.ProductDao;
import com.wei.springbootmall2.Service.ProductService;
import com.wei.springbootmall2.dto.ProductQueryParams;
import com.wei.springbootmall2.dto.ProductRequest;
import com.wei.springbootmall2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.PrintService;
import java.util.List;

@Component

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
            return productDao.getProducts(productQueryParams);}
    //public List<Product> getProducts(ProductCategory category,String search) {
    //    return productDao.getProducts(category,search);}

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

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
