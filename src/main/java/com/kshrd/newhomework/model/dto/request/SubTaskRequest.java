package com.kshrd.newhomework.model.dto.request;

import com.kshrd.newhomework.model.SubTask;
import com.kshrd.newhomework.model.Task;
import com.kshrd.newhomework.model.enums.ESubTaskStatus;

public record SubTaskRequest(String title, ESubTaskStatus status) {

    public SubTask toEntity(Task task) {
        return new SubTask(null, title, status, task);
    }

    public SubTask toEntity(Long id, Task task) {
        return new SubTask(id, title, status, task);
    }

}
