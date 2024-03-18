package hu.bb.todolist.controller;

import hu.bb.todolist.model.Task;
import hu.bb.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/task")
public class TaskController extends GenericController<Task>{

    @Autowired
    public TaskController(TaskService taskService) {
        super(taskService);
    }
}
