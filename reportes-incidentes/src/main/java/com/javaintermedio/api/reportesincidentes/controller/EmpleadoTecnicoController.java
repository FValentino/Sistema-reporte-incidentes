package com.javaintermedio.api.reportesincidentes.controller;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoTecnico;
import com.javaintermedio.api.reportesincidentes.service.EmpleadoTecnicoService;
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
public class EmpleadoTecnicoController {
    
    private EmpleadoTecnicoService empelado;
    
    @Autowired
    public EmpleadoTecnicoController(EmpleadoTecnicoService empleado){
        this.empelado = empleado;
    }
    
    //CRUD BASICO
    @GetMapping (value = "/reportes-incidentes/empleados/tecnico", headers="Accept=application/json")
    @ResponseBody
    public List <EmpleadoTecnico> mostrarTodos(){
        return this.empelado.mostrarTodos();
    }
    
    @PostMapping (value = "/reportes-incidentes/empleados/tecnico/agregar", headers="Accept=application/json")
    public void agregarEmpleado(@RequestBody EmpleadoTecnico empleado){
        this.empelado.agregarEmpleadoTecnico(empleado);
    }
    
    @GetMapping (value = "/reportes-incidentes/empleados/tecnico/{id}", headers="Accept=application/json")
    @ResponseBody
    public Optional<EmpleadoTecnico> buscarEmpleado(@PathVariable long id){
        return this.empelado.buscarEmpleadoTecnico(id);
    }
    
    @DeleteMapping (value = "/reportes-incidentes/empleados/tecnico/eliminar/{id}", headers="Accept=application/json")
    public void eliminarEmpleado (@PathVariable long id){
        this.empelado.eliminarEmpleadoTecnico(id);
    }
    
    @PutMapping (value = "/reportes-incidentes/empleados/tecnico/actualizar/{id}", headers="Accept=application/json")
    public void modificarEmpleado (@PathVariable long id, @RequestBody EmpleadoTecnico empelado){
        this.empelado.modificarEmpleadoTecnico(id, empelado);
    }
}