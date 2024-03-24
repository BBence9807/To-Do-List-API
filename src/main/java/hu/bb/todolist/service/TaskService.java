package hu.bb.todolist.service;

import hu.bb.todolist.model.Task;
import hu.bb.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends GenericService<Task>{


    public TaskService(TaskRepository taskRepository) {
        super(taskRepository);
    }

    @Override
    public String getName() {
        return "Task";
    }

    @Override
    public boolean validate(Task task) {
        if(task == null)
            return false;

        return task.getTitle() != null && task.getCompleted() != null && task.getTaskType() != null && task.getDueDate() != null;
    }

    @Override
    public Task mod(Task actualTask, Task newTask) {

        if(newTask.getTitle()!=null)
            actualTask.setTitle(newTask.getTitle());

        if(newTask.getDescription() != null)
            actualTask.setDescription(newTask.getDescription());

        if(newTask.getCompleted() != null)
            actualTask.setCompleted(newTask.getCompleted());

        if(newTask.getDueDate() != null)
            actualTask.setDueDate(newTask.getDueDate());

        if(newTask.getTaskType() != null)
            actualTask.setTaskType(newTask.getTaskType());

        return actualTask;
    }
}
