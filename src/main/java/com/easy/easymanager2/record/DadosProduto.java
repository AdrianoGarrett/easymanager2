package com.easy.easymanager2.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosProduto(
        @NotBlank
        String name,
        @NotBlank
        String category,
        @NotNull
        Integer user_id
) {
}
