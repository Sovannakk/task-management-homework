package com.kshrd.newhomework.service.impl;

import com.kshrd.newhomework.model.Project;
import com.kshrd.newhomework.model.Task;
import com.kshrd.newhomework.model.dto.request.TaskRequest;
import com.kshrd.newhomework.model.dto.response.TaskResponse;
import com.kshrd.newhomework.repository.TaskRepository;
import com.kshrd.newhomework.service.ProjectService;
import com.kshrd.newhomework.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectService projectService;

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        Project project = projectService.getProject(taskRequest.projectId()).toEntity();
        return taskRepository.save(taskRequest.toEntity(project)).toResponse();
    }

    @Override
    public TaskResponse getTask(Long id) {
        return taskRepository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
        Project project = projectService.getProject(id).toEntity();
        Task task = taskRepository.findById(id).orElseThrow();
        return taskRepository.save(taskRequest.toEntity(id, project, task.getTags(), task.getSubTasks(), task.getComments())).toResponse();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream().map(Task::toResponse).toList();
    }



}
