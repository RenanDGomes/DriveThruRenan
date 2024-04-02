package com.DriveThru.DriveThru.controller;



import com.DriveThru.DriveThru.model.Produto;
import com.DriveThru.DriveThru.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Usada para marcar uma classe como um controller no padrão MVC (Model-View-Controller) do Spring.
@RequestMapping("/produtos") // Especifica a URL que um método do controlador irá manipular.
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProduto(){
        return produtoService.listarProduto();
    }

    @PostMapping
    public Produto criarProduto(@Valid @RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<?> editarProduto(@PathVariable Long idProduto, @RequestBody Produto produto){
        if( produtoService.editarProduto(produto, idProduto) == null) {
            String mensagem = " o id informado nao existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long idProduto){
        if(produtoService.excluirProduto(idProduto)){
            String mensagem = "A deleção do id: " + idProduto + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = " o id informado nao existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
}
