package com.joao.cursospring.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "cliente") // caso o nome da tabela seja diferente do nome da entidade
public class Cliente {

    @Id // obrigatoria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // nao obrigatoria so caso nome seja diferente na tabela
    private int id;

    @Column(name = "nome", length = 100)
    @NotEmpty(message = "Campo nome é obrigatorio")
    private String nome;

    @Column(name = "cpf", length = 11)
    @NotEmpty(message = "Campo cpf é obrigatorio")
    @CPF(message = "Informe um cpf valido")
    private String cpf;

    @JsonIgnore // nao retornar os pedidos na requisicao
    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
