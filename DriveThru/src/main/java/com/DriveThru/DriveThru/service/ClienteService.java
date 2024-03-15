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

    public Cliente editarCliente(Long id, Cliente cliente){
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        } return null;
    }

    public boolean excluirCliente(Long id){
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } return false;
    }
}

