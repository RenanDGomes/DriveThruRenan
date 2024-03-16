package com.DriveThru.DriveThru.service;

import com.DriveThru.DriveThru.repository.ClienteRepository;
import com.DriveThru.DriveThru.repository.ProdutoRepository;
import com.DriveThru.DriveThru.model.Cliente;
import com.DriveThru.DriveThru.model.Pedido;
import com.DriveThru.DriveThru.model.Produto;
import com.DriveThru.DriveThru.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> listarPedido() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(Pedido pedido) {
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getIdCliente()).orElse(null);
        Produto produto = produtoRepository.findById(pedido.getProduto().getIdProduto()).orElse(null);
        if (cliente != null && produto != null) {
            pedido.setCliente(cliente);
            pedido.setProduto(produto);
            return pedidoRepository.save(pedido);
        }return null;
    }

    public Pedido editarPedido(Long idPedido, Pedido pedido){
        if (pedidoRepository.existsById(idPedido)) {
            pedido.setIdPedido(idPedido);
            return pedidoRepository.save(pedido);
        } return null;
    }

    public boolean excluirPedido(Long idPedido){
        if(pedidoRepository.existsById(idPedido)){
            pedidoRepository.deleteById(idPedido);
            return true;
        } return false;
    }
}

