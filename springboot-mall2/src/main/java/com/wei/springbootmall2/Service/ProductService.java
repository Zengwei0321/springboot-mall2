package com.wei.springbootmall2.Service;

import com.wei.springbootmall2.Constant.ProductCategory;
import com.wei.springbootmall2.dto.ProductQueryParams;
import com.wei.springbootmall2.dto.ProductRequest;
import com.wei.springbootmall2.model.Product;

import java.util.List;

public interface ProductService {
    //這是比較直接的用法 下面是進階的比較好整理 List<Product> getProducts(ProductCategory category,String search);
    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
