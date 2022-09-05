package com.joao.cursospring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.cursospring.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer> {
    
}
