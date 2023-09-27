package com.example.product.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDTO {

    @NotNull
    private String productId;

    @NotNull
    private String productName;

    @NotNull
    private int productPrice;

    @NotNull
    private int productStock;

}
