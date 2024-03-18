package hu.bb.todolist.controller;

import hu.bb.todolist.model.BaseEntity;
import hu.bb.todolist.service.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public abstract class GenericController<E extends BaseEntity> {

    private GenericService<E> genericService;

    public GenericController(GenericService<E> genericService){
        this.genericService = genericService;
    }


    @GetMapping
    public ResponseEntity<List<E>> getEntities(){
        return genericService.findAll();
    }

    @GetMapping("/:id")
    public ResponseEntity<E> getEntityById(@RequestParam("id") Long id){
        return genericService.findById(id);
    }

    @PostMapping
    public ResponseEntity<E> saveNewEntity(@RequestBody E entity){
        return genericService.saveNewEntity(entity);
    }

    @PutMapping
    public ResponseEntity<E> modifyEntity(@RequestBody E entity){
        return genericService.modEntity(entity);
    }

    @DeleteMapping("/:id")
    public ResponseEntity<Boolean> deleteEntity(@RequestParam("id") Long id){
        return genericService.deleteEntity(id);
    }

}
