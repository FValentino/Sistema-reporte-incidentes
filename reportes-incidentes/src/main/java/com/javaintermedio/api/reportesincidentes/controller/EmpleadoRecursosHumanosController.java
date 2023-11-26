package com.javaintermedio.api.reportesincidentes.controller;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoRecursosHumanos;
import com.javaintermedio.api.reportesincidentes.service.EmpleadoRecursosHumanosService;
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
public class EmpleadoRecursosHumanosController {
    
    private EmpleadoRecursosHumanosService empelado;
    
    @Autowired
    public EmpleadoRecursosHumanosController(EmpleadoRecursosHumanosService empleado){
        this.empelado = empleado;
    }
    
    //CRUD BASICO
    @GetMapping (value = "/reportes-incidentes/empleados/recursos-humanos", headers="Accept=application/json")
    @ResponseBody
    public List <EmpleadoRecursosHumanos> mostrarTodos(){
        return this.empelado.mostrarTodos();
    }
    
    @PostMapping (value = "/reportes-incidentes/empleados/recursos-humanos/agregar", headers="Accept=application/json")
    public void agregarEmpleado(@RequestBody EmpleadoRecursosHumanos empleado){
        this.empelado.agregarEmpleadoRecursosHumanos(empleado);
    }
    
    @GetMapping (value = "/reportes-incidentes/empleados/recursos-humanos/{id}", headers="Accept=application/json")
    @ResponseBody
    public Optional<EmpleadoRecursosHumanos> buscarEmpleado(@PathVariable long id){
        return this.empelado.buscarEmpleadoRecursosHumanos(id);
    }
    
    @DeleteMapping (value = "/reportes-incidentes/empleados/recursos-humanos/eliminar/{id}", headers="Accept=application/json")
    public void eliminarEmpleado (@PathVariable long id){
        this.empelado.eliminarEmpleadoRecursosHumanos(id);
    }
    
    @PutMapping (value = "/reportes-incidentes/empleados/recursos-humanos/actualizar/{id}", headers="Accept=application/json")
    public void modificarEmpleado (@PathVariable long id, @RequestBody EmpleadoRecursosHumanos empelado){
        this.empelado.modificarEmpleadoRecursosHumanos(id, empelado);
    }
}
