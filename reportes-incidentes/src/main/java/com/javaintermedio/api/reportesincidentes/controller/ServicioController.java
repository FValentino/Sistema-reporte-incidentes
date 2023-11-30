package com.javaintermedio.api.reportesincidentes.controller;

import com.javaintermedio.api.reportesincidentes.model.Servicio;
import com.javaintermedio.api.reportesincidentes.service.ServicioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicioController {
    
    @Autowired
    private ServicioService servicio;
    
    
    //CRUD BASICO
    @GetMapping (value = "/reportes-incidentes/servicios", headers = "Accept = application/json")
    public List <Servicio> mostrarTodos(){
        return this.servicio.mostrarTodos();
    }
    
    @PostMapping (value = "/reportes-incidentes/servicios/agregar", headers="Accept=application/json")
    public String agregarServicio (@RequestBody Servicio servicio){
        this.servicio.agregarServicio(servicio);
        return "Cliente creado";
    }
    
    @GetMapping (value = "/reportes-incidentes/servicios/{id}", headers="Accept=application/json")
    @ResponseBody
    public Optional<Servicio> mostrarServicio (@PathVariable long id){
        return this.servicio.buscarIncidente(id);
    }
    
    @PutMapping (value = "/reportes-incidentes/servicios/actualizar", headers="Accept=application/json")
    public void modificarServicio (@RequestBody Servicio servicio){
        this.servicio.modificarIncidente(servicio);
    }
    
    @DeleteMapping (value = "/reportes-incidentes/servicios/eliminar/{id}", headers="Accept=application/json")
    public void eliminarServicio (@PathVariable long id){
        this.servicio.eliminarServicio(id);
    }
}
