package hu.bb.todolist;

import hu.bb.todolist.model.Task;
import hu.bb.todolist.model.TaskType;
import hu.bb.todolist.model.TodoListResponse;
import hu.bb.todolist.repository.TaskRepository;
import hu.bb.todolist.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @InjectMocks
    private static TaskService taskService;

    @Mock
    private static TaskRepository taskRepository;


    private Task getInitTask(){
        TaskType taskType = TaskType.builder().name("TestType").build();

        return Task.builder().title("TestTitle")
                .completed(false)
                .dueDate(new Date())
                .description("Test")
                .taskType(taskType)
                .build();
    }

    @Test
    public void findAllTest(){
        Task task = getInitTask();
        //when(taskRepository.save(task)).thenReturn(task);
        taskService.saveNewEntity(task);
        TodoListResponse<List<Task>> all = taskService.findAll().getBody();

        Assertions.assertTrue(all.getResult() != null);
    }


}
