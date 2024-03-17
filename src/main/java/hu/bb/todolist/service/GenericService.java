package hu.bb.todolist.service;

import hu.bb.todolist.repository.GenericRepository;
import java.util.Collections;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class GenericService<E> {

    private GenericRepository<E> genericRepository;

    public GenericService(GenericRepository<E> genericRepository){
        this.genericRepository = genericRepository;
    }

    public List<E> findAll(){
        return Collections.emptyList();
    }

    public E findById(){
        return null;
    }

    public E saveNewEntity(E entity){
        return null;
    }

    public E modEntity(E entity){
        return null;
    }

    public Boolean deleteEntity(){
        return null;
    }

    public abstract Boolean validate();
    public abstract E save();
    public abstract E mod();

}
