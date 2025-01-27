package com.easy.easymanager2.controller;

import com.easy.easymanager2.model.Product;
import com.easy.easymanager2.record.DadosListagemProduct;
import com.easy.easymanager2.record.DadosProduto;
import com.easy.easymanager2.repository.DadosProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/gerencia")
public class EasyManagerController {

    @Autowired
    private DadosProdutoRepository dadosProdutoRepository;

    @PostMapping
    public void cadastraProduto(@RequestBody @Valid DadosProduto dados){
        dadosProdutoRepository.save(new Product(dados));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Integer id){
      var product =  dadosProdutoRepository.getReferenceById(id);
    }

    @GetMapping
    public Page<DadosListagemProduct> list (@PageableDefault(size = 5, sort = {"name"}) Pageable paginacao){
        return dadosProdutoRepository.findAll(paginacao).map(DadosListagemProduct::new);
    }

}
