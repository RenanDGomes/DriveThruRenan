package com.DriveThru.DriveThru.repository;

import com.DriveThru.DriveThru.model.Produto;
import com.DriveThru.DriveThru.service.ProdutoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @RestController
    @RequestMapping("/api/produtos")
    public class ProdutoController {
        private final ProdutoService produtoService;
        public ProdutoController(ProdutoService produtoService) {
            this.produtoService = produtoService;
        }

        @GetMapping("/mais-caro")
        public ResponseEntity<Produto> encontrarProdutoMaisCaro() {
            Produto produtoMaisCaro = produtoService.encontrarProdutoMaisCaro();
            if (produtoMaisCaro != null) {
                return ResponseEntity.ok(produtoMaisCaro);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }

        @GetMapping("/mais-barato")
        public ResponseEntity<Produto> encontrarProdutoMaisBarato() {
            Produto produtoMaisBarato = produtoService.encontrarProdutoMaisBarato();
            if (produtoMaisBarato != null) {
                return ResponseEntity.ok(produtoMaisBarato);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }

    }

}