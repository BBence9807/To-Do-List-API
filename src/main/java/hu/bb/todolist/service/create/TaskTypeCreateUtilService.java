package hu.bb.todolist.service.create;

import hu.bb.todolist.model.TaskType;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeCreateUtilService {

    public TaskType create(TaskType actualTaskType, TaskType newTaskType){
        if(newTaskType.getName() != null)
            actualTaskType.setName(newTaskType.getName());

        return actualTaskType;
    }
}
