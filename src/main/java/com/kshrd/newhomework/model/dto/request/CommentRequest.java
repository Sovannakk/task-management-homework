package com.kshrd.newhomework.model.dto.request;

import com.kshrd.newhomework.model.Comment;
import com.kshrd.newhomework.model.Task;

public record CommentRequest(String content) {

    public Comment toEntity(Task task) {
        return new Comment(null, content, task);
    }

}
