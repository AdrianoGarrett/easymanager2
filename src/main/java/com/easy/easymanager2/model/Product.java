package com.easy.easymanager2.model;

import com.easy.easymanager2.record.DadosProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "products")
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
    private Integer user_id;
    private boolean ativo;

    public Product(){

    }
    public Product(DadosProduto dados) {
        this.name = dados.name();
        this.category = dados.category();
        this.user_id = dados.user_id();
    }

    public void delete() {
        this.ativo = false;
    }
}
