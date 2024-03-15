package com.DriveThru.DriveThru.service;


import com.DriveThru.DriveThru.model.Pedido;
import com.DriveThru.DriveThru.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> listarPedido() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }


}

