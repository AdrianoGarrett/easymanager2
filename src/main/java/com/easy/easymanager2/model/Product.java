package com.easy.easymanager2.model;

import com.easy.easymanager2.record.DadosProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "dim_products")
@Entity(name = "Product")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String category;
    private Double cost_price;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Product(){

    }
    public Product(DadosProduto dados) {
        this.name = dados.name();
        this.category = dados.category();
        this.cost_price = dados.cost_price();
        Customer customer = new Customer();
        customer.setId(dados.customer_id());
        this.customer = customer;
    }

}
