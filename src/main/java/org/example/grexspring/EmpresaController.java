package org.example.grexspring;

import jakarta.validation.Valid;
import org.example.grexspring.validation.Actualizar;
import org.example.grexspring.validation.Crear;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping; //?
import org.springframework.web.bind.annotation.RequestMapping; //?
import org.springframework.web.bind.annotation.RestController; //?

import org.springframework.web.bind.annotation.*; //?

import java.util.List; //?
import java.util.Optional;

@RestController //?
@RequestMapping("empresas") //?

public class EmpresaController {

    private final EmpresaService service;

    public EmpresaController(EmpresaService service){
        this.service=service;
    }

    /*//Leer de la base de datos ---
    private final Repositorio repositorio;

    public EmpresaController(Repositorio repositorio){
        this.repositorio=repositorio;
    }
    //---*/

    /*
    //READ ALL
    @GetMapping
    public List<Empresa> listar(){
        return repositorio.findAll();
    }*/

    //READ ALL (EXCEPT N)
    @GetMapping
    public List<Empresa> listar(){
        return service.findByEstadoRegistroNotContaining("n");
    }

    //READ N
    @GetMapping("n")
    public List<Empresa> listarN(){
        return service.findByEstadoRegistroContaining("n");
    }

    /*
    //READ (FIND) BY ID
    @GetMapping("/id/{id}")
    public Optional<Empresa> listarPorID(@PathVariable Long id){
        return repositorio.findById(id);
    }
    */

    /*
    //READ (FIND) BY SECTOR
    @GetMapping("/sector/{sector}")
    public List<Empresa> listarPorSector(@PathVariable String sector){
        return repositorio.findBySector(sector);
    }
    */

    //@PostMapping indica que responde a peticiones HTTP POST
    //@RequestBody le dice a Spring que convierta el JSON recibido en un objeto Empresa
    //repositorio.save() guarda el objeto en la base de datos
    //Spring devuelve automáticamente el objeto guardado como JSON
    @PostMapping
    public String crear(@Validated(Crear.class) @RequestBody Empresa empresa){
        service.crear(empresa);
        return "Empresa añadida.";
    }

    //DELETE REAL
    /*@DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        repositorio.deleteById(id);
        return "Empresa eliminada.";
    }*/

    //UPDATE
    @PutMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @Validated(Actualizar.class) @RequestBody Empresa empresaActualizada) {
        service.actualizar(id, empresaActualizada);
        return "Empresa editada.";
    }

    /*@GetMapping //?
    public String hola(){ //Test de prueba
        return "API funcionando!";
    }*/
}
