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
    
    public void eliminarCliente(long id){
        clienteRepo.deleteById(id);
    }
    
    public Optional<Cliente> buscarCliente(long id){
        return clienteRepo.findById(id);
    }
    
    public List <Cliente> mostrarTodos(){
        return clienteRepo.findAll();
    }
    
    public void modificarCliente(long id, Cliente cliente){
        
        Cliente cli = this.clienteRepo.findById(id).orElse(cliente);
        cli.setCuit(cliente.getCuit());
        cli.setRazonSocial(cliente.getRazonSocial());
        cli.setTelefono(cliente.getTelefono());
        cli.setDireccion(cliente.getDireccion());
        
        clienteRepo.save(cli);
    }
}
