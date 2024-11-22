package com.kshrd.newhomework.controller;

import com.kshrd.newhomework.model.apiresponse.ApiResponse;
import com.kshrd.newhomework.model.dto.request.CommentRequest;
import com.kshrd.newhomework.model.dto.response.CommentResponse;
import com.kshrd.newhomework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/tasks/{taskId}")
    private ResponseEntity<ApiResponse<CommentResponse>> postComment(@PathVariable Long taskId, @RequestBody CommentRequest commentRequest) {
        commentService.postComment(taskId, commentRequest);
        ApiResponse<CommentResponse> response = new ApiResponse<>(
                "Post comment successfully",
                HttpStatus.CREATED,
                null,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/tasks/{taskId}")
    private ResponseEntity<ApiResponse<List<CommentResponse>>> getAllCommentByTaskId(@PathVariable Long taskId) {
        ApiResponse<List<CommentResponse>> response = new ApiResponse<>(
                "Get all comments by taskId successfully",
                HttpStatus.OK,
                commentService.getAllCommentByTaskId(taskId),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ApiResponse<CommentResponse>> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        ApiResponse<CommentResponse> response = new ApiResponse<>(
                "Delete comment successfully",
                HttpStatus.OK,
                null,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
