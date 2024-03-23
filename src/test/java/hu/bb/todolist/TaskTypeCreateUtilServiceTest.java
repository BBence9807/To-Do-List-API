package hu.bb.todolist;

import hu.bb.todolist.model.TaskType;
import hu.bb.todolist.service.create.TaskTypeCreateUtilService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TaskTypeCreateUtilServiceTest {

    private static TaskTypeCreateUtilService taskTypeCreateUtilService;
    private static TaskType actualTaskType;
    private static TaskType newTaskType;

    @BeforeAll
    public static void init(){
        taskTypeCreateUtilService = new TaskTypeCreateUtilService();

        actualTaskType = TaskType.builder().name("TestName").build();
        newTaskType = TaskType.builder().name("TestNameMod").build();
    }

    @Test
    public void modifyNameTest(){
        String expectedName = "TestNameMod";

        Assertions.assertEquals(expectedName,taskTypeCreateUtilService.create(actualTaskType,newTaskType).getName());
    }


}
