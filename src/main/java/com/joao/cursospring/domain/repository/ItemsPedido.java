package com.joao.cursospring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.cursospring.domain.entity.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
    
}
