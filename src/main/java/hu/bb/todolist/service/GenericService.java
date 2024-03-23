package hu.bb.todolist.service;

import hu.bb.todolist.model.BaseEntity;
import hu.bb.todolist.model.ToDoListMessage;
import hu.bb.todolist.model.TodoListResponse;
import hu.bb.todolist.repository.GenericRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public abstract class GenericService<E extends BaseEntity> {

    private GenericRepository<E> genericRepository;

    protected GenericService(GenericRepository<E> genericRepository){
        this.genericRepository = genericRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<TodoListResponse<List<E>>> findAll(){
        try {
            List<E> entites = (List<E>) genericRepository.findAll();

            if(!entites.isEmpty())
                return new ResponseEntity<>(new TodoListResponse<>(entites, getMessage(ToDoListMessage.GET_ALL_ENTITIES_SUCCESS.getMessage())), HttpStatus.OK);
            else
                return new ResponseEntity<>(new TodoListResponse<>(null, getMessage(ToDoListMessage.GET_ALL_ENTITIES_FAILED.getMessage())), HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(new TodoListResponse<>(null, getMessage(ToDoListMessage.GET_ALL_ENTITIES_FAILED.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional(readOnly = true)
    public ResponseEntity<TodoListResponse<E>> findById(Long id){
        try {

            if(genericRepository.existsById(id)){
                Optional<E> entity = genericRepository.findById(id);

                if(!entity.isEmpty())
                    return new ResponseEntity<>(new TodoListResponse<>(entity.get(),getMessage(ToDoListMessage.GET_ENTITY_SUCCESS.getMessage())),HttpStatus.OK);
                else
                    return new ResponseEntity<>(new TodoListResponse<>(null,getMessage(ToDoListMessage.GET_ENTITY_FAILED.getMessage())),HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(new TodoListResponse<>(null,getMessage(ToDoListMessage.GET_ENTITY_FAILED.getMessage())),HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(new TodoListResponse<>(null, getMessage(ToDoListMessage.GET_ENTITY_FAILED.getMessage())),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional()
    public ResponseEntity<TodoListResponse<E>> saveNewEntity(E entity){
        try {
         if(!validate(entity))
             return new ResponseEntity<>(new TodoListResponse<>(null, this.getMessage(ToDoListMessage.POST_ENTITY_FAILED.getMessage())), HttpStatus.BAD_REQUEST);

         return new ResponseEntity<>(new TodoListResponse<>(genericRepository.save(entity),this.getMessage(ToDoListMessage.POST_ENTITY_SUCCESS.getMessage())),HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(new TodoListResponse<>(null, this.getMessage(ToDoListMessage.POST_ENTITY_FAILED.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional()
    public ResponseEntity<TodoListResponse<E>> modEntity(E entity, Long id){
        try {
            if(!validate(entity))
                return new ResponseEntity<>(new TodoListResponse<>(null, this.getMessage(ToDoListMessage.PUT_ENTITY_FAILED.getMessage())), HttpStatus.BAD_REQUEST);


            if(genericRepository.existsById(id))
            {
                Optional<E> en = genericRepository.findById(id);

                if(!en.isEmpty())
                    return new ResponseEntity<>(new TodoListResponse<>(genericRepository.save(this.mod(en.get(),entity)),getMessage(ToDoListMessage.PUT_ENTITY_SUCCESS.getMessage())),HttpStatus.OK);
                else
                    return new ResponseEntity<>(new TodoListResponse<>(null,getMessage(ToDoListMessage.PUT_ENTITY_FAILED.getMessage())),HttpStatus.NOT_FOUND);

            }

            return new ResponseEntity<>(new TodoListResponse<>(null,getMessage(ToDoListMessage.PUT_ENTITY_FAILED.getMessage())),HttpStatus.NOT_FOUND);


        }catch (Exception e){
            return new ResponseEntity<>(new TodoListResponse<>(null, this.getMessage(ToDoListMessage.PUT_ENTITY_FAILED.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional()
    public ResponseEntity<TodoListResponse<Boolean>> deleteEntity(Long id){
        try {
            if(!genericRepository.existsById(id))
                return new ResponseEntity<>(new TodoListResponse<>(null,getMessage(ToDoListMessage.DELETE_ENTITY_FAILED.getMessage())),HttpStatus.NOT_FOUND);

            genericRepository.deleteById(id);

            return new ResponseEntity<>(new TodoListResponse<>(true, this.getMessage(ToDoListMessage.DELETE_ENTITY_SUCCESS.getMessage())),HttpStatus.NO_CONTENT);

        }catch (Exception e){
            return new ResponseEntity<>(new TodoListResponse<>(null, this.getMessage(ToDoListMessage.DELETE_ENTITY_FAILED.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private String getMessage(String msg){
        return String.format(msg,this.getName());
    }

    public abstract String getName();
    public abstract boolean validate(E entity);
    public abstract E mod(E actualEntity, E newEntity);

}
