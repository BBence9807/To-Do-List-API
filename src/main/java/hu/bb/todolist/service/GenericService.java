package hu.bb.todolist.service;

import hu.bb.todolist.model.BaseEntity;
import hu.bb.todolist.model.TodoListResponse;
import hu.bb.todolist.repository.GenericRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


public abstract class GenericService<E extends BaseEntity> {

    private GenericRepository<E> genericRepository;

    public GenericService(GenericRepository<E> genericRepository){
        this.genericRepository = genericRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<TodoListResponse<List<E>>> findAll(){
        return (ResponseEntity<TodoListResponse<List<E>>>) Collections.emptyList();
    }

    public ResponseEntity<TodoListResponse<E>> findById(Long id){
        return null;
    }

    public ResponseEntity<TodoListResponse<E>> saveNewEntity(E entity){
        return null;
    }

    public ResponseEntity<TodoListResponse<E>> modEntity(E entity, Long id){
        return null;
    }

    public ResponseEntity<TodoListResponse<Boolean>> deleteEntity(Long id){
        return null;
    }

    public abstract String getName();
    public abstract Boolean validate();
    public abstract E save();
    public abstract E mod();

}
