package com.joao.cursospring.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.cursospring.domain.entity.Cliente;
import com.joao.cursospring.domain.entity.Pedido;


public interface Pedidos extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}
