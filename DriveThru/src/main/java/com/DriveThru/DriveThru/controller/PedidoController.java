package com.DriveThru.DriveThru.controller;


import com.DriveThru.DriveThru.model.Pedido;
import com.DriveThru.DriveThru.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Usada para marcar uma classe como um controller no padrão MVC (Model-View-Controller) do Spring.
@RequestMapping("/pedidos") // Especifica a URL que um método do controlador irá manipular.
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarPedido(){
        return pedidoService.listarPedido();
    }

    @PostMapping
    public Pedido criarPedido(@Valid @RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }



}
