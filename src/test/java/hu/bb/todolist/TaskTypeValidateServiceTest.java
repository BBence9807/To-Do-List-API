package hu.bb.todolist;

import hu.bb.todolist.model.TaskType;
import hu.bb.todolist.service.validate.TaskTypeValidateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TaskTypeValidateServiceTest {

    private static TaskTypeValidateService taskTypeValidateService;

    @BeforeAll
    public static void init(){
        taskTypeValidateService = new TaskTypeValidateService();
    }

    @Test
    public void checkFullEmpty(){
        Assertions.assertEquals(false,taskTypeValidateService.validate(null));
    }

    @Test
    public void checkNameEmpty(){
        Assertions.assertEquals(false,taskTypeValidateService.validate(new TaskType()));
    }

    @Test
    public void checkNotEmpty(){
        Assertions.assertEquals(true,taskTypeValidateService.validate(new TaskType("Test")));
    }
}
