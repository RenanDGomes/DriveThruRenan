package com.DriveThru.DriveThru.service;


import com.DriveThru.DriveThru.model.Produto;
import com.DriveThru.DriveThru.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements CrudProdutoService<Produto>{

    @Autowired
    ProdutoRepository produtoRepository;
    @Override
    public List<Produto> listarProduto(){
        return produtoRepository.findAll();
    }

    @Override
    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    @Override
    public Produto editarProduto(Produto produto, Long idProduto){
        if(produtoRepository.existsById(idProduto)){
            produto.setIdProduto(idProduto);
            return produtoRepository.save(produto);
        }return null;
    }

    @Override
    public boolean excluirProduto(Long idProduto){
        if(produtoRepository.existsById(idProduto)){
            produtoRepository.deleteById(idProduto);
            return true;
        } return false;
    }
}
