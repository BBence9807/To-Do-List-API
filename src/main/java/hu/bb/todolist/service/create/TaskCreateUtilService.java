package hu.bb.todolist.service.create;

import hu.bb.todolist.model.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskCreateUtilService {

    public Task create(Task actualTask,Task newTask){

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
