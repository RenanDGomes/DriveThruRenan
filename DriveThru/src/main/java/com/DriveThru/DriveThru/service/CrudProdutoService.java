package com.DriveThru.DriveThru.service;

import java.util.List;

public interface CrudProdutoService<T> {
    List<T> listarProduto();
    T criarProduto(T t);
    T editarProduto(T t, Long idProduto);
    boolean excluirProduto(Long idProduto);
}