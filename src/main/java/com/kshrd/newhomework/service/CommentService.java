package com.kshrd.newhomework.service;

import com.kshrd.newhomework.model.dto.request.CommentRequest;
import com.kshrd.newhomework.model.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {

    void postComment(Long taskId, CommentRequest commentRequest);

    List<CommentResponse> getAllCommentByTaskId(Long taskId);

    void deleteComment(Long id);
}
