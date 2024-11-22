package com.kshrd.newhomework.model.dto.request;

import com.kshrd.newhomework.model.*;
import com.kshrd.newhomework.model.enums.EPriority;

import java.time.LocalDate;
import java.util.List;

public record TaskRequest(String title, String description, LocalDate dueDate, EPriority priority, Long projectId) {

    public Task toEntity(Project project) {
        return new Task(null, title, description, dueDate, priority, project, null, null, null);
    }

    public Task toEntity(Long id, Project project, List<Tag> tags, List<SubTask> subTasks, List<Comment> comments) {
        return new Task(id, title, description, dueDate, priority, project, tags, subTasks, comments);
    }

}
