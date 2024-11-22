package com.kshrd.newhomework.service.impl;

import com.kshrd.newhomework.model.Comment;
import com.kshrd.newhomework.model.Task;
import com.kshrd.newhomework.model.dto.request.CommentRequest;
import com.kshrd.newhomework.model.dto.response.CommentResponse;
import com.kshrd.newhomework.repository.CommentRepository;
import com.kshrd.newhomework.repository.TaskRepository;
import com.kshrd.newhomework.service.CommentService;
import com.kshrd.newhomework.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Override
    public void postComment(Long taskId, CommentRequest commentRequest) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        commentRepository.save(commentRequest.toEntity(task)).toResponse();
    }

    @Override
    public List<CommentResponse> getAllCommentByTaskId(Long taskId) {
        return commentRepository.getAllCommentByTaskId(taskId).stream().map(Comment::toResponse).toList();
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
