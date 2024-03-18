package hu.bb.todolist.service;

import hu.bb.todolist.model.Task;
import hu.bb.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends GenericService<Task>{

    public TaskService(TaskRepository taskRepository) {
        super(taskRepository);
    }

    @Override
    public Boolean validate() {
        return null;
    }

    @Override
    public Task save() {
        return null;
    }

    @Override
    public Task mod() {
        return null;
    }
}
