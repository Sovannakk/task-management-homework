package com.kshrd.newhomework.model.dto.response;

import com.kshrd.newhomework.model.enums.EPriority;

import java.time.LocalDate;
import java.util.List;

public record TaskResponse(Long id, String title, String description, EPriority priority, LocalDate dueDate,
                           ProjectResponse projectResponse, List<TagResponse> tagResponses,
                           List<SubTaskResponse> subTaskResponses,
                           List<CommentResponse> commentResponses) {
}
