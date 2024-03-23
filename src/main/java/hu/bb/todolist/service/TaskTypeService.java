package hu.bb.todolist.service;

import hu.bb.todolist.model.TaskType;
import hu.bb.todolist.repository.TaskTypeRepository;
import hu.bb.todolist.service.create.TaskTypeCreateUtilService;
import hu.bb.todolist.service.validate.TaskTypeValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeService extends GenericService<TaskType> {

    @Autowired
    private TaskTypeValidateService taskTypeValidateService;

    @Autowired
    private TaskTypeCreateUtilService taskTypeCreateUtilService;

    public TaskTypeService(TaskTypeRepository taskTypeRepository) {
        super(taskTypeRepository);
    }

    @Override
    public String getName() {
        return "TaskType";
    }

    @Override
    public boolean validate(TaskType taskType) {
        return taskTypeValidateService.validate(taskType);
    }

    @Override
    public TaskType mod(TaskType actualTaskType, TaskType newTaskType) {
        return taskTypeCreateUtilService.create(actualTaskType,newTaskType);
    }
}
