package com.E_Commerce.E_Commerce.dtos;

import lombok.Data;

@Data
public class RemoveCartItemDTO {
    private int userId;
    private int productId;
}
