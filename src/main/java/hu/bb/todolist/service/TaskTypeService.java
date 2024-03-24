package hu.bb.todolist.service;

import hu.bb.todolist.model.TaskType;
import hu.bb.todolist.repository.TaskTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeService extends GenericService<TaskType> {


    public TaskTypeService(TaskTypeRepository taskTypeRepository) {
        super(taskTypeRepository);
    }

    @Override
    public String getName() {
        return "TaskType";
    }

    @Override
    public boolean validate(TaskType taskType) {
        if(taskType == null)
            return false;

        return taskType.getName() != null;
    }

    @Override
    public TaskType mod(TaskType actualTaskType, TaskType newTaskType) {
        if(newTaskType.getName() != null)
            actualTaskType.setName(newTaskType.getName());

        return actualTaskType;
    }
}
