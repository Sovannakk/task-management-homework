package com.kshrd.newhomework.service.impl;

import com.kshrd.newhomework.model.SubTask;
import com.kshrd.newhomework.model.Task;
import com.kshrd.newhomework.model.dto.request.SubTaskRequest;
import com.kshrd.newhomework.model.dto.response.SubTaskResponse;
import com.kshrd.newhomework.repository.SubTaskRepository;
import com.kshrd.newhomework.repository.TaskRepository;
import com.kshrd.newhomework.service.SubTaskService;
import com.kshrd.newhomework.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubTaskServiceImpl implements SubTaskService {

    private final SubTaskRepository subTaskRepository;
    private final TaskRepository taskRepository;

    @Override
    public SubTaskResponse createSubTask(Long taskId, SubTaskRequest subTaskRequest) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        return subTaskRepository.save(subTaskRequest.toEntity(task)).toResponse();
    }

    @Override
    public SubTaskResponse updateSubTask(Long id, SubTaskRequest subTaskRequest) {
        SubTask subTask = subTaskRepository.findById(id).orElseThrow();
        Task task = taskRepository.findById(subTask.getTask().getId()).orElseThrow();
        return subTaskRepository.save(subTaskRequest.toEntity(id, task)).toResponse();
    }

    @Override
    public void deleteSubTask(Long id) {
        subTaskRepository.deleteById(id);
    }

    @Override
    public List<SubTaskResponse> getAllSubTasks(Long taskId) {
        return subTaskRepository.findAllByTaskId(taskId).stream().map(SubTask::toResponse).toList();
    }
}
