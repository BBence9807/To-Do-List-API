package hu.bb.todolist;

import hu.bb.todolist.model.Task;
import hu.bb.todolist.model.TaskType;
import hu.bb.todolist.repository.TaskRepository;
import hu.bb.todolist.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TaskServiceUtilTest {


    @InjectMocks
    private static TaskService taskService;

    @Mock
    private static TaskRepository taskRepository;

    private static Task actualTask;
    private static Task newTask;

    @BeforeAll
    public static void init(){
        actualTask = Task.builder()
                .title("TestTitle")
                .description("TestDesc")
                .completed(false)
                .dueDate(new Date())
                .taskType(new TaskType("TestType"))
                .build();


        newTask = Task.builder()
                .title("TestTitleMod")
                .description("TestDescMod")
                .completed(true)
                .dueDate(modNewDate())
                .taskType(modNewTaskType())
                .build();
    }

    private static Date modNewDate(){
        Date date = new Date();
        date.setTime(2);

        return date;
    }

    private static TaskType modNewTaskType(){
        return new TaskType("TestTypeMod");
    }

    @Test
    public void validateFullEmpty(){
        Assertions.assertEquals(false,taskService.validate(null));
    }

    @Test
    public void validateTitleEmpty(){
        Assertions.assertEquals(false,taskService.validate(
                Task.builder()
                        .description("test")
                        .completed(false)
                        .taskType(modNewTaskType())
                        .dueDate(new Date()).build()
        ));
    }

    @Test
    public void validateCompletedEmpty(){
        Assertions.assertEquals(false,taskService.validate(
                Task.builder()
                        .title("Test")
                        .description("test")
                        .taskType(modNewTaskType())
                        .dueDate(new Date()).build()
        ));
    }

    @Test
    public void validateTaskTypeEmpty(){
        Assertions.assertEquals(false,taskService.validate(
                Task.builder()
                        .title("Test")
                        .description("test")
                        .completed(false)
                        .dueDate(new Date()).build()
        ));
    }

    @Test
    public void validateDueDateEmpty(){
        Assertions.assertEquals(false,taskService.validate(
                Task.builder()
                        .title("Test")
                        .description("test")
                        .completed(false)
                        .taskType(modNewTaskType()).build()
        ));
    }

    @Test
    public void validateIsNotEmpty(){
        Assertions.assertEquals(true,taskService.validate(
                Task.builder()
                        .title("Test")
                        .description("test")
                        .completed(false)
                        .taskType(modNewTaskType())
                        .dueDate(new Date()).build()
        ));
    }

    @Test
    public void modifyTitleTest(){
        String expectTitle = "TestTitleMod";

        Assertions.assertEquals(expectTitle,taskService.mod(actualTask,newTask).getTitle());
    }

    @Test
    public void modifyDescriptionTest(){
        String expectDescription = "TestDescMod";

        Assertions.assertEquals(expectDescription,taskService.mod(actualTask,newTask).getDescription());
    }

    @Test
    public void modifyCompletedTest(){
        Assertions.assertEquals(true,taskService.mod(actualTask,newTask).getCompleted());
    }

    @Test
    public void modifyDueDateTest(){
        Assertions.assertEquals(modNewDate(),taskService.mod(actualTask,newTask).getDueDate());
    }

    @Test
    public void modifyTaskTypeTest(){
        Assertions.assertEquals(modNewTaskType().getName(),taskService.mod(actualTask,newTask).getTaskType().getName());
    }

}
