package com.DriveThru.DriveThru.model;

import jakarta.persistence.Id;

public class Pedido {
    @Id
    private  long idPedido;
    private Produto produto;
    private Cliente cliente;
    private Produto qtdeProduto;

    public Pedido() {
    }

    public Pedido(long idPedido, Produto produto, Cliente cliente, Produto qtdeProduto) {
        this.idPedido = idPedido;
        this.produto = produto;
        this.cliente = cliente;
        this.qtdeProduto = qtdeProduto;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(Produto qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }
}
