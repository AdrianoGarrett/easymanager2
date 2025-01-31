package com.easy.easymanager2.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCustomer (
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        String email,
        @NotBlank
        @Pattern(regexp = "^(\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})$",
                message = "WRONG PHONE NUMBER. ACCEPTED FORMATS: (123) 456-7890, 123-456-7890")
        String phoneNumber,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String country,
        @NotBlank
        String gender,
        @NotBlank
        String companyId
     ){
}
