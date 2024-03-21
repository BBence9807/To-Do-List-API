package hu.bb.todolist.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoListResponse<T> {

    private T entity;
    private String message;
}
