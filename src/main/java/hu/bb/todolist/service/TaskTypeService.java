package hu.bb.todolist.service;

import hu.bb.todolist.model.TaskType;
import hu.bb.todolist.repository.TaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeService extends GenericService<TaskType> {

    public TaskTypeService(TaskTypeRepository taskTypeRepository) {
        super(taskTypeRepository);
    }

    @Override
    public Boolean validate() {
        return null;
    }

    @Override
    public TaskType save() {
        return null;
    }

    @Override
    public TaskType mod() {
        return null;
    }
}
