package com.easy.easymanager2.record;

public record LoginResponse(
        String status,  // Exemplo: "success" ou "error"
        String message  // Exemplo: "admin", "user", ou "Credenciais inválidas!"
) {}
