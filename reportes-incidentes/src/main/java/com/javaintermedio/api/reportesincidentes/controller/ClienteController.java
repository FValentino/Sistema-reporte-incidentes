package com.javaintermedio.api.reportesincidentes.controller;

import com.javaintermedio.api.reportesincidentes.model.Cliente;
import com.javaintermedio.api.reportesincidentes.service.ClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reportes-incidentes")
public class ClienteController {
    
    private ClienteService cliente;
    
    @Autowired
    public ClienteController (ClienteService cliente){
        this.cliente = cliente;
    }
    
    //CRUD basico
    @GetMapping(value = "/clientes", headers="Accept=application/json") 
    @ResponseBody
    public List <Cliente> mostrarClientes (){
        return this.cliente.mostrarTodos();
    }
    
    @PostMapping (value = "/clientes/agregar", headers="Accept=application/json")
    public String agregarCliente (@RequestBody Cliente cliente){
        this.cliente.agregarCliente(cliente);
        return "Cliente creado";
    }
    
    @GetMapping (value = "/clientes/{id}", headers="Accept=application/json")
    @ResponseBody
    public Optional<Cliente> mostrarCliente (@PathVariable long id){
        return this.cliente.buscarCliente(id);
    }
    
    @PutMapping (value = "/clientes/actualizar/{id}", headers="Accept=application/json")
    public void modificarCliente (@PathVariable long id, @RequestBody Cliente cliente){
        this.cliente.modificarCliente(id, cliente);
    }
    
    @DeleteMapping (value = "/clientes/eliminar/{id}", headers="Accept=application/json")
    public void eliminarCliente (@PathVariable long id){
        this.cliente.eliminarCliente(id);
    }
}
