package com.crud.tasks.domain;

import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskTestSuite {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testTaskDaoSave() {
        //Given
        Task task = new Task(1L, "new task title", "new task content");

        //When
        taskRepository.save(task);

        //Then
        Long id = task.getId();
        System.out.println(id);

        //CleanUp
        taskRepository.deleteAll();
    }
}
