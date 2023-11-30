package com.javaintermedio.api.reportesincidentes.controller;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoMesaAyuda;
import com.javaintermedio.api.reportesincidentes.model.Usuario;
import com.javaintermedio.api.reportesincidentes.service.EmpleadoMesaAyudaService;
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
public class EmpleadoMesaAyudaController {
    
    @Autowired
    private EmpleadoMesaAyudaService empelado;
    @Autowired
    private UsuarioService usuario;
    
    //CRUD BASICO
    @GetMapping (value = "/empleados/mesa-ayuda", headers="Accept=application/json")
    @ResponseBody
    public List <EmpleadoMesaAyuda> mostrarTodos(){
        return this.empelado.mostrarTodos();
    }
    
    @PostMapping (value = "/empleados/mesa-ayuda/agregar", headers="Accept=application/json")
    public void agregarEmpleado(@RequestBody EmpleadoMesaAyuda empleado){
        this.empelado.agregarEmpleadoMesaAyuda(empleado);
    }
    
    @GetMapping (value = "/empleados/mesa-ayuda/{id}", headers="Accept=application/json")
    @ResponseBody
    public Optional<EmpleadoMesaAyuda> buscarEmpleado(@PathVariable long id){
        return this.empelado.buscarEmpleadoMesaAyuda(id);
    }
    
    @DeleteMapping (value = "/empleados/mesa-ayuda/eliminar/{id}", headers="Accept=application/json")
    public void eliminarEmpleado (@PathVariable long id){
        this.empelado.eliminarEmpleadoMesaAyuda(id);
    }
    
    @PutMapping (value = "/empleados/mesa-ayuda/actualizar/{id}", headers="Accept=application/json")
    public void modificarEmpleado (@PathVariable long id, @RequestBody EmpleadoMesaAyuda empelado){
        this.empelado.modificarEmpleadoMesaAyuda(id, empelado);
    }
    
    @PutMapping (value = "/reportes-incidentes/empleados/mesa-ayuda/actualizar/contraseña/{id}", headers="Accept=application/json")
    public void modificarPassword (@PathVariable long id, @RequestBody Usuario usuario){
        this.usuario.modificarPassword(id, usuario.getPassword());
    }
}
