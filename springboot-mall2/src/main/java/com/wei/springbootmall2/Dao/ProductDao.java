package com.wei.springbootmall2.Dao;

import com.wei.springbootmall2.Constant.ProductCategory;
import com.wei.springbootmall2.dto.ProductQueryParams;
import com.wei.springbootmall2.dto.ProductRequest;
import com.wei.springbootmall2.model.Product;

import java.util.List;

public interface ProductDao {
    //List<Product> getProducts(ProductCategory category,String search);
    Integer countProduct(ProductQueryParams productQueryParams);
    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);



}
