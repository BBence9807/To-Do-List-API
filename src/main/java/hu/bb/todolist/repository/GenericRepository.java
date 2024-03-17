package hu.bb.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository<E> extends CrudRepository<E,Long> {
}
