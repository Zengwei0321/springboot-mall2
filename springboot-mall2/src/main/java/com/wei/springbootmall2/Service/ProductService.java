package com.wei.springbootmall2.Service;

import com.wei.springbootmall2.Constant.ProductCategory;
import com.wei.springbootmall2.dto.ProductRequest;
import com.wei.springbootmall2.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductCategory category,String search);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
