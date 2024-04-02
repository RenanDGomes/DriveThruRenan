package com.DriveThru.DriveThru.service;

import com.DriveThru.DriveThru.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.DriveThru.DriveThru.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements CrudClienteService<Cliente> {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarCliente(){
        return clienteRepository.findAll();
    }

    @Override
    public Cliente criarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente editarCliente(Cliente cliente, Long idCliente){
        if (clienteRepository.existsById(idCliente)) {
            cliente.setIdCliente(idCliente);
            return clienteRepository.save(cliente);
        } return null;
    }

    @Override
    public boolean excluirCliente(Long idCliente){
        if(clienteRepository.existsById(idCliente)) {
            clienteRepository.deleteById(idCliente);
            return true;
        } return false;
    }
}

