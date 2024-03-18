package hu.bb.todolist.controller;

import hu.bb.todolist.model.TaskType;
import hu.bb.todolist.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/task-type")
public class TaskTypeController extends GenericController<TaskType> {

    @Autowired
    public TaskTypeController(TaskTypeService taskTypeService) {
        super(taskTypeService);
    }
}
