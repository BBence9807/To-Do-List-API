package hu.bb.todolist.service.validate;

import hu.bb.todolist.model.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskValidateService {

    public boolean check(Task task){
        if(task == null)
            return false;

        return task.getTitle() != null && task.getCompleted() != null && task.getTaskType() != null && task.getDueDate() != null;
    }
}
