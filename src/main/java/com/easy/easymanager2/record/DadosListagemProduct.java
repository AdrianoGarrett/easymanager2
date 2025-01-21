package com.easy.easymanager2.record;

import com.easy.easymanager2.model.Product;

public record DadosListagemProduct(String name, String category) {
    public DadosListagemProduct(Product product){
        this(product.getName(),product.getCategory());
    }
}
