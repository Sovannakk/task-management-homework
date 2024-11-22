package com.kshrd.newhomework.service;

import com.kshrd.newhomework.model.dto.request.SubTaskRequest;
import com.kshrd.newhomework.model.dto.response.SubTaskResponse;

import java.util.List;

public interface SubTaskService {

    SubTaskResponse createSubTask(Long taskId, SubTaskRequest subTaskRequest);

    SubTaskResponse updateSubTask(Long id, SubTaskRequest subTaskRequest);

    void deleteSubTask(Long id);

    List<SubTaskResponse> getAllSubTasks(Long taskId);
}
