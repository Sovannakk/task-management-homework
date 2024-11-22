package com.kshrd.newhomework.service;

import com.kshrd.newhomework.model.dto.request.TaskRequest;
import com.kshrd.newhomework.model.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskRequest taskRequest);

    TaskResponse getTask(Long id);

    TaskResponse updateTask(Long id, TaskRequest taskRequest);

    void deleteTask(Long id);

    List<TaskResponse> getAllTasks();
}
