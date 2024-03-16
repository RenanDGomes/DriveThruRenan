package com.DriveThru.DriveThru.service;

import com.DriveThru.DriveThru.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.DriveThru.DriveThru.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listarCliente(){
        return clienteRepository.findAll();
    }

    public Cliente criarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente editarCliente(Long idCliente, Cliente cliente){
        if (clienteRepository.existsById(idCliente)) {
            cliente.setIdCliente(idCliente);
            return clienteRepository.save(cliente);
        } return null;
    }

    public boolean excluirCliente(Long idCliente){
        if(clienteRepository.existsById(idCliente)) {
            clienteRepository.deleteById(idCliente);
            return true;
        } return false;
    }
}

