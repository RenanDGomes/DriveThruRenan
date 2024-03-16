package com.DriveThru.DriveThru.controller;


import com.DriveThru.DriveThru.model.Pedido;
import com.DriveThru.DriveThru.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{idPedido}")
    public ResponseEntity<?> editarPedido(@PathVariable Long idPedido, @RequestBody Pedido pedido){
        if(pedidoService.editarPedido(idPedido, pedido) == null){
            String mensagem = "o id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{idPedido}")
    public ResponseEntity<?> excluirPedido(@PathVariable Long idPedido){
        if(pedidoService.excluirPedido(idPedido)){
            String mensagem = "A deleção do id:" + idPedido + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        } String mensagem = "o id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
}

