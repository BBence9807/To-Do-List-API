package hu.bb.todolist;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "To-Do List Application Programming Interface",version = "1.0.0", description = "API for To-Do List"))
public class ToDoListApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApiApplication.class, args);
	}

}
