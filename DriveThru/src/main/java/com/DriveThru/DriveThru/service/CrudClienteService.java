package com.DriveThru.DriveThru.service;

import java.util.List;

public interface CrudClienteService<T> {
    List<T> listarCliente();
    T criarCliente(T t);
    T editarCliente(T t, Long idCliente);
    boolean excluirCliente(Long idCliente);
}