package com.javaintermedio.api.reportesincidentes.controller;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoRecursosHumanos;
import com.javaintermedio.api.reportesincidentes.model.Usuario;
import com.javaintermedio.api.reportesincidentes.service.EmpleadoRecursosHumanosService;
import com.javaintermedio.api.reportesincidentes.service.UsuarioService;
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
public class EmpleadoRecursosHumanosController {
    
    @Autowired
    private EmpleadoRecursosHumanosService empelado;
    @Autowired
    private UsuarioService usuario;
    
    
    //CRUD BASICO
    @GetMapping (value = "/empleados/recursos-humanos", headers="Accept=application/json")
    @ResponseBody
    public List <EmpleadoRecursosHumanos> mostrarTodos(){
        return this.empelado.mostrarTodos();
    }
    
    @PostMapping (value = "/empleados/recursos-humanos/agregar", headers="Accept=application/json")
    public void agregarEmpleado(@RequestBody EmpleadoRecursosHumanos empleado){
        this.empelado.agregarEmpleadoRecursosHumanos(empleado);
    }
    
    @GetMapping (value = "/empleados/recursos-humanos/{id}", headers="Accept=application/json")
    @ResponseBody
    public Optional<EmpleadoRecursosHumanos> buscarEmpleado(@PathVariable long id){
        return this.empelado.buscarEmpleadoRecursosHumanos(id);
    }
    
    @DeleteMapping (value = "/empleados/recursos-humanos/eliminar/{id}", headers="Accept=application/json")
    public void eliminarEmpleado (@PathVariable long id){
        this.empelado.eliminarEmpleadoRecursosHumanos(id);
    }
    
    @PutMapping (value = "/empleados/recursos-humanos/actualizar/{id}", headers="Accept=application/json")
    public void modificarEmpleado (@PathVariable long id, @RequestBody EmpleadoRecursosHumanos empelado){
        this.empelado.modificarEmpleadoRecursosHumanos(id, empelado);
    }
    
    @PutMapping (value = "/empleados/ecursos-humanos/actualizar/contraseña/{id}", headers="Accept=application/json")
    public void modificarPassword (@PathVariable long id, @RequestBody Usuario usuario){
        this.usuario.modificarPassword(id, usuario.getPassword());
    }
}
