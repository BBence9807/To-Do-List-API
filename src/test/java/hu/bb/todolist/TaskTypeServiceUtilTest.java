package hu.bb.todolist;

import hu.bb.todolist.model.TaskType;
import hu.bb.todolist.repository.TaskTypeRepository;
import hu.bb.todolist.service.TaskTypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TaskTypeServiceUtilTest {

    @InjectMocks
    private static TaskTypeService taskTypeService;

    @Mock
    private static TaskTypeRepository taskTypeRepository;

    private static TaskType actualTaskType;
    private static TaskType newTaskType;


    @BeforeAll
    public static void init(){
        actualTaskType = TaskType.builder().name("TestName").build();
        newTaskType = TaskType.builder().name("TestNameMod").build();
    }

    @Test
    public void checkFullEmpty(){
        Assertions.assertEquals(false,taskTypeService.validate(null));
    }

    @Test
    public void checkNameEmpty(){
        Assertions.assertEquals(false,taskTypeService.validate(new TaskType()));
    }

    @Test
    public void checkNotEmpty(){
        Assertions.assertEquals(true,taskTypeService.validate(new TaskType("Test")));
    }

    @Test
    public void modifyNameTest(){
        String expectedName = "TestNameMod";

        Assertions.assertEquals(expectedName,taskTypeService.mod(actualTaskType,newTaskType).getName());
    }
}
