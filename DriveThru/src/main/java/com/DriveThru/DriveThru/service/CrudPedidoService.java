package com.DriveThru.DriveThru.service;

import java.util.List;

public interface CrudPedidoService<T> {
    List<T> listarPedido();
    T criarPedido(T t);
    T editarPedido(T t, Long idPedido);
    boolean excluirPedido(Long idPedido);



}