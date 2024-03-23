package hu.bb.todolist.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoListResponse<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;
    private String message;
}
