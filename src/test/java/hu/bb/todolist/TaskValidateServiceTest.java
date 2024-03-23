package hu.bb.todolist;

import hu.bb.todolist.model.Task;
import hu.bb.todolist.model.TaskType;
import hu.bb.todolist.service.validate.TaskValidateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TaskValidateServiceTest {

    private static TaskValidateService taskValidateService;

    @BeforeAll
    public static void init(){
       taskValidateService = new TaskValidateService();
    }


    @Test
    public void checkFullEmpty(){
        Assertions.assertEquals(false,taskValidateService.check(null));
    }

    @Test
    public void checkTitleEmpty(){
        Assertions.assertEquals(false,taskValidateService.check(
                Task.builder()
                        .description("test")
                        .completed(false)
                        .taskType(new TaskType("Test"))
                        .dueDate(new Date()).build()
        ));
    }

    @Test
    public void checkCompletedEmpty(){
        Assertions.assertEquals(false,taskValidateService.check(
                Task.builder()
                        .title("Test")
                        .description("test")
                        .taskType(new TaskType("Test"))
                        .dueDate(new Date()).build()
        ));
    }

    @Test
    public void checkTaskTypeEmpty(){
        Assertions.assertEquals(false,taskValidateService.check(
                Task.builder()
                        .title("Test")
                        .description("test")
                        .completed(false)
                        .dueDate(new Date()).build()
        ));
    }

    @Test
    public void checkDueDateEmpty(){
        Assertions.assertEquals(false,taskValidateService.check(
                Task.builder()
                        .title("Test")
                        .description("test")
                        .completed(false)
                        .taskType(new TaskType("Test")).build()
        ));
    }

    @Test
    public void checkIsNotEmpty(){
        Assertions.assertEquals(true,taskValidateService.check(
                Task.builder()
                        .title("Test")
                        .description("test")
                        .completed(false)
                        .taskType(new TaskType("Test"))
                        .dueDate(new Date()).build()
        ));
    }

}
