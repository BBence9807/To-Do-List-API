package hu.bb.todolist.service;

import hu.bb.todolist.model.BaseEntity;
import hu.bb.todolist.repository.GenericRepository;
import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public abstract class GenericService<E extends BaseEntity> {

    private GenericRepository<E> genericRepository;

    public GenericService(GenericRepository<E> genericRepository){
        this.genericRepository = genericRepository;
    }

    public ResponseEntity<List<E>> findAll(){
        return (ResponseEntity<List<E>>) Collections.emptyList();
    }

    public ResponseEntity<E> findById(Long id){
        return null;
    }

    public ResponseEntity<E> saveNewEntity(E entity){
        return null;
    }

    public ResponseEntity<E> modEntity(E entity){
        return null;
    }

    public ResponseEntity<Boolean> deleteEntity(Long id){
        return null;
    }

    public abstract Boolean validate();
    public abstract E save();
    public abstract E mod();

}
