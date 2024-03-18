package hu.bb.todolist.repository;

import hu.bb.todolist.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface GenericRepository<E extends BaseEntity> extends CrudRepository<E,Long> {
}
