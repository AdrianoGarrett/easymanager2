package com.easy.easymanager2.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosProduto(
        @NotBlank
        String name,
        @NotBlank
        String category,
        @NotNull
        Double cost_price,
        @NotNull
        Integer customer_id
) {
}
