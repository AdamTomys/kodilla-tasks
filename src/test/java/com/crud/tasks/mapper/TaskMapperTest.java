package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.dto.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1l, "title", "content");

        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(Task.class, mappedTask.getClass());
        assertEquals("title", mappedTask.getTitle());
        assertEquals("content", mappedTask.getContent());
        assertEquals(1L, mappedTask.getId());
    }

    @Test
    void mapToTaskDto() {
        //Given
        Task task = new Task(1l, "title", "content");

        //When
        TaskDto mappedTask = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(TaskDto.class, mappedTask.getClass());
        assertEquals("title", mappedTask.getTitle());
        assertEquals("content", mappedTask.getContent());
        assertEquals(1L, mappedTask.getId());
    }

    @Test
    void mapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>(Arrays.asList(new Task(1l, "title", "content")));

        //When
        List<TaskDto> mappedList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(TaskDto.class, mappedList.get(0).getClass());
        assertEquals("title", mappedList.get(0).getTitle());
        assertEquals("content", mappedList.get(0).getContent());
        assertEquals(1L, mappedList.get(0).getId());
    }
}