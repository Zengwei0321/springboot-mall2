package com.wei.springbootmall2.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BuyItem {
    @NotNull
    private Integer productId;
    @NotNull
    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
