package com.DriveThru.DriveThru.service;


import com.DriveThru.DriveThru.model.Produto;
import com.DriveThru.DriveThru.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> listarProduto(){
        return produtoRepository.findAll();
    }
    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto editarProduto(Long idProduto, Produto produto){
        if(produtoRepository.existsById(idProduto)){
            produto.setIdProduto(idProduto);
            return produtoRepository.save(produto);
        }return null;
    }

    public boolean excluirProduto(Long idProduto){
        if(produtoRepository.existsById(idProduto)){
            produtoRepository.deleteById(idProduto);
            return true;
        } return false;
    }
}
