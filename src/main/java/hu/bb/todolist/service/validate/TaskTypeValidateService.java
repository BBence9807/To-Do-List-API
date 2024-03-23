package hu.bb.todolist.service.validate;

import hu.bb.todolist.model.TaskType;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeValidateService {

    public boolean validate(TaskType taskType){
        if(taskType == null)
            return false;

        return taskType.getName() != null;
    }
}
