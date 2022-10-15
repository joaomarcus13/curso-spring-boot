package com.joao.cursospring.service;

import java.util.Optional;

import com.joao.cursospring.api.dto.PedidoDTO;
import com.joao.cursospring.domain.entity.Pedido;
import com.joao.cursospring.domain.enums.StatusPedido;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    Optional<Pedido> getById(Integer id);

    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
