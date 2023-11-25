package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.Cliente;
import com.javaintermedio.api.reportesincidentes.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepo;
    
    //Crud basico
    public void agregarCliente(Cliente cliente){
        clienteRepo.save(cliente);
    }
    
    public void eliminarCliente(int cuit){
        clienteRepo.deleteById(cuit);
    }
    
    public Optional<Cliente> buscarCliente(int cuit){
        return clienteRepo.findById(cuit);
    }
    
    public List <Cliente> mostrarTodos(){
        return clienteRepo.findAll();
    }
    
    public void modificarCliente(Cliente cliente){
        
        clienteRepo.save(cliente);
    }
}
