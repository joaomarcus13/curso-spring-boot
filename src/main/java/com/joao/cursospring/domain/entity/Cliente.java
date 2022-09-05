package com.joao.cursospring.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cliente") //caso o nome da tabela seja diferente do nome da entidade
public class Cliente {

    @Id //obrigatoria
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="id")  //nao obrigatoria so caso nome seja diferente na tabela
    private int id;

    @Column(name="nome",length = 100)
    private String nome;

    @Column(name="cpf",length = 11)
    private String cpf;

   

    @JsonIgnore //nao retornar os pedidos na requisicao
    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;

    public Cliente(){
    }
    public Cliente( String nome){
        this.nome = nome;
    }


    public Set<Pedido> getPedidos(){
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString(){
        return "Cliente{" + "id=" + id + ", nome='" + nome + '\'' + '}'; 
    }
    
}
