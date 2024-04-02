package com.DriveThru.DriveThru.controller;

import com.DriveThru.DriveThru.model.Cliente;
import com.DriveThru.DriveThru.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired // é usada para realizar a injeção de dependência automática em beans gerenciados pelo contêiner Spring
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarCliente(){
        return clienteService.listarCliente();
    }

    @PostMapping
    public Cliente criarCliente(@Valid @RequestBody Cliente cliente){
        return clienteService.criarCliente(cliente);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<?> editarCliente(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
        if (clienteService.editarCliente(cliente, idCliente) == null) {
            String mensagem = " o id informado nao existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<?> excluirCliente(@PathVariable Long idCliente) {
        if (clienteService.excluirCliente(idCliente)) {
            String mensagem = "A deleção do id: " + idCliente + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = " o id informado nao existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
}
