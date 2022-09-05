package com.joao.cursospring.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.joao.cursospring.domain.entity.Produto;
import com.joao.cursospring.domain.repository.Produtos;


@RequestMapping("/api/produtos")
@RestController
public class ProdutoController {
    
    Produtos produtos;

    public ProdutoController(@Autowired Produtos produtos){
        this.produtos = produtos;
    }

    @GetMapping
    public List<Produto> find(){
        return produtos.findAll();
    }

    @GetMapping("/{id}")
    public Produto findOne( @PathVariable Integer id){
        return produtos.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto create(@RequestBody Produto produto){
        return produtos.save(produto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        produtos.findById(id)
                .map( p -> {
                    produtos.deleteById(id);
                   return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto não encontrado") );
    }
}
