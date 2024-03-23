package hu.bb.todolist.service;

import hu.bb.todolist.model.Task;
import hu.bb.todolist.repository.TaskRepository;
import hu.bb.todolist.service.create.TaskCreateUtilService;
import hu.bb.todolist.service.validate.TaskValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends GenericService<Task>{

    @Autowired
    private TaskValidateService taskValidateService;

    @Autowired
    private TaskCreateUtilService taskCreateUtilService;

    public TaskService(TaskRepository taskRepository) {
        super(taskRepository);
    }

    @Override
    public String getName() {
        return "Task";
    }

    @Override
    public boolean validate(Task entity) {
        return taskValidateService.check(entity);
    }

    @Override
    public Task mod(Task actualTask, Task newTask) {
        return taskCreateUtilService.create(actualTask,newTask);
    }
}
