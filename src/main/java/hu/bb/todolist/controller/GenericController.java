package hu.bb.todolist.controller;

import hu.bb.todolist.model.BaseEntity;
import hu.bb.todolist.model.TodoListResponse;
import hu.bb.todolist.service.GenericService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public abstract class GenericController<E extends BaseEntity> {

    private GenericService<E> genericService;

    public GenericController(GenericService<E> genericService){
        this.genericService = genericService;
    }


    @Operation(summary = "Get all", description = "Returns all entities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "OK: Successfully retrieved entities"),
            @ApiResponse(responseCode = "404",description = "Not Found: No entity found."),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
        }
    )
    @GetMapping
    public ResponseEntity<TodoListResponse<List<E>>> getEntities(){
        return genericService.findAll();
    }

    @Operation(summary = "Get by Id", description = "Returns entity by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "OK: Successfully retrieved entity by ID"),
            @ApiResponse(responseCode = "404",description = "Not Found: No entity found by ID."),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
        }
    )
    @GetMapping("/:id")
    public ResponseEntity<TodoListResponse<E>> getEntityById(@RequestParam("id") Long id){
        return genericService.findById(id);
    }


    @Operation(summary = "Create", description = "Create new entity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Created: Entity successfully created"),
            @ApiResponse(responseCode = "400",description = "Bad Request: Invalid request body."),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
        }
    )
    @PostMapping
    public ResponseEntity<TodoListResponse<E>> saveNewEntity(@RequestBody E entity){
        return genericService.saveNewEntity(entity);
    }


    @Operation(summary = "Modify entity by ID", description = "Modify entity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "OK: Entity successfully updated."),
            @ApiResponse(responseCode = "404",description = "Not Found: Entity not found for the given ID."),
            @ApiResponse(responseCode = "400",description = "Bad Request: Invalid request body."),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
        }
    )
    @PutMapping("/:id")
    public ResponseEntity<TodoListResponse<E>> modifyEntity(@RequestBody E entity, @RequestParam("id") Long id){
        return genericService.modEntity(entity,id);
    }


    @Operation(summary = "Delete entity by ID", description = "Delete entity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "No Content: Entity successfully deleted."),
            @ApiResponse(responseCode = "404",description = "Not Found: Entity not found for the given ID."),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
        }
    )
    @DeleteMapping("/:id")
    public ResponseEntity<TodoListResponse<Boolean>> deleteEntity(@RequestParam("id") Long id){
        return genericService.deleteEntity(id);
    }

}
