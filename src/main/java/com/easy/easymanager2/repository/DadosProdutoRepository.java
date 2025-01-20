package com.easy.easymanager2.repository;

import com.easy.easymanager2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosProdutoRepository extends JpaRepository<Product,Integer> {
}
