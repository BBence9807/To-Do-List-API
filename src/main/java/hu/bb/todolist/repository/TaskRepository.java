package hu.bb.todolist.repository;

import hu.bb.todolist.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends GenericRepository<Task>{
}
