package hu.bb.todolist.repository;

import hu.bb.todolist.model.TaskType;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTypeRepository extends GenericRepository<TaskType> {
}
