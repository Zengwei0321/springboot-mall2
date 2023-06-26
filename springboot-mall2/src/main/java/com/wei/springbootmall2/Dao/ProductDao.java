package com.wei.springbootmall2.Dao;

import com.wei.springbootmall2.dto.ProductRequest;
import com.wei.springbootmall2.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);


}
