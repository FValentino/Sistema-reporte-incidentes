package com.javaintermedio.api.reportesincidentes.controller;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoComercial;
import com.javaintermedio.api.reportesincidentes.service.EmpleadoComercialService;
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
public class EmpleadoComercialController {

    private EmpleadoComercialService empelado;
    
    @Autowired
    public EmpleadoComercialController(EmpleadoComercialService empleado){
        this.empelado = empleado;
    }
    
    //CRUD BASICO
    @GetMapping (value = "/reportes-incidentes/empleados/comercial", headers="Accept=application/json")
    @ResponseBody
    public List <EmpleadoComercial> mostrarTodos(){
        return this.empelado.mostrarTodos();
    }
    
    @PostMapping (value = "/reportes-incidentes/empleados/comercial/agregar", headers="Accept=application/json")
    public void agregarEmpleado(@RequestBody EmpleadoComercial empleado){
        this.empelado.agregarEmpleadoComercial(empleado);
    }
    
    @GetMapping (value = "/reportes-incidentes/empleados/comercial/{id}", headers="Accept=application/json")
    @ResponseBody
    public Optional<EmpleadoComercial> buscarEmpleado(@PathVariable long id){
        return this.empelado.buscarEmpleadoComercial(id);
    }
    
    @DeleteMapping (value = "/reportes-incidentes/empleados/comercial/eliminar/{id}", headers="Accept=application/json")
    public void eliminarEmpleado (@PathVariable long id){
        this.empelado.eliminarEmpleadoComercial(id);
    }
    
    @PutMapping (value = "/reportes-incidentes/empleados/comercial/actualizar/{id}", headers="Accept=application/json")
    public void modificarEmpleado (@PathVariable long id, @RequestBody EmpleadoComercial empleado){
        this.empelado.modificarEmpleadoComercial(id, empleado);
    }
}
