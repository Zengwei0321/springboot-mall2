package com.wei.springbootmall2.Dao.Impl;

import com.wei.springbootmall2.Constant.ProductCategory;
import com.wei.springbootmall2.Dao.ProductDao;
import com.wei.springbootmall2.RowMapper.ProductRowMapper;
import com.wei.springbootmall2.dto.ProductQueryParams;
import com.wei.springbootmall2.dto.ProductRequest;
import com.wei.springbootmall2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Product> getProducts(ProductQueryParams productQueryParams){
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description," +
                " created_date, last_modified_date " +
                "FROM product WHERE 1=1";
            //上面WHERE 1=1 不會影響查詢結果 只是為了銜接下面IF 判斷式後面的SQL"
        Map<String,Object> map = new HashMap<>();

        if(productQueryParams.getCategory() != null){
            sql = sql + " AND category = :category";
            //記得AND前面加上空白建 才能銜接上面的 WHERE 1=1 SQL
            map.put("category", productQueryParams.getCategory().name());
        } //這裡使用.name() 將 eunm類型轉換成字串 才能使用
        if(productQueryParams.getSearch() != null){
            sql = sql + " AND product_name LIKE :search";
            map.put("search", "%" + productQueryParams.getSearch() + "%");
        }       //% 只能加在 map裡面  Spring JDBC Template的限制
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return productList;
    }

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, created_date, last_modified_date FROM product WHERE product_id = :productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId",productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0){
            return productList.get(0);
        }else{
            return null;
        }

    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product(product_name, category, image_url, price, stock," +
                " description, created_date, last_modified_date) " +
                "VALUES(:productName, :category, :imageUrl, :price, :stock, :description," +
                ":createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int productId = keyHolder.getKey().intValue();

        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE product SET product_name=:productName, category=:category, image_url=:imageUrl, " +
                "price=:price, stock=:stock, description=:description, last_modified_date=:lastModifiedDate " +
                "WHERE product_id=:productId";


        Map<String, Object> map = new HashMap<>();
        map.put("productId",productId);

        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql ="DELETE FROM product WHERE product_id =:productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);

    }


}
