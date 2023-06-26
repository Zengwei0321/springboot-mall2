package com.wei.springbootmall2.Service;

import com.wei.springbootmall2.dto.ProductRequest;
import com.wei.springbootmall2.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);
}
