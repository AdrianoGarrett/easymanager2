package com.easy.easymanager2.record;

import com.easy.easymanager2.model.Customer;
import com.easy.easymanager2.model.Product;

public record DadosListagemProduct(String name, String category, Double cost_price, DadosResumidosCustomer  customer) {
    public DadosListagemProduct(Product product){
        this(product.getName(),product.getCategory(), product.getCost_price(), new DadosResumidosCustomer(product.getCustomer()));
    }
}
