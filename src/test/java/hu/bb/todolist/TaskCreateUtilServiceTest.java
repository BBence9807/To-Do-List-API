package hu.bb.todolist;

import hu.bb.todolist.model.Task;
import hu.bb.todolist.model.TaskType;
import hu.bb.todolist.service.create.TaskCreateUtilService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TaskCreateUtilServiceTest {

    private static TaskCreateUtilService taskCreateUtilService;
    private static Task actualTask;
    private static Task newTask;

    @BeforeAll
    public static void init(){
        taskCreateUtilService = new TaskCreateUtilService();
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
                .dueDate(createNewDate())
                .taskType(createNewTaskType())
                .build();

    }

    private static Date createNewDate(){
        Date date = new Date();
        date.setTime(2);

        return date;
    }

    private static TaskType createNewTaskType(){
        return new TaskType("TestTypeMod");
    }

    @Test
    public void modifyTitleTest(){
        String expectTitle = "TestTitleMod";

        Assertions.assertEquals(expectTitle,taskCreateUtilService.create(actualTask,newTask).getTitle());
    }

    @Test
    public void modifyDescriptionTest(){
        String expectDescription = "TestDescMod";

        Assertions.assertEquals(expectDescription,taskCreateUtilService.create(actualTask,newTask).getDescription());
    }

    @Test
    public void modifyCompletedTest(){
        Assertions.assertEquals(true,taskCreateUtilService.create(actualTask,newTask).getCompleted());
    }

    @Test
    public void modifyDueDateTest(){
        Assertions.assertEquals(createNewDate(),taskCreateUtilService.create(actualTask,newTask).getDueDate());
    }

    @Test
    public void modifyTaskTypeTest(){
        Assertions.assertEquals(createNewTaskType().getName(),taskCreateUtilService.create(actualTask,newTask).getTaskType().getName());
    }
}
