package com.kshrd.newhomework.controller;

import com.kshrd.newhomework.model.apiresponse.ApiResponse;
import com.kshrd.newhomework.model.dto.request.SubTaskRequest;
import com.kshrd.newhomework.model.dto.response.SubTaskResponse;
import com.kshrd.newhomework.service.SubTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/subtasks")
@RequiredArgsConstructor
public class SubTaskController {
    
    private final SubTaskService subTaskService;

    @PostMapping("/tasks/{taskId}")
    private ResponseEntity<ApiResponse<SubTaskResponse>> createSubTask(@PathVariable Long taskId, @RequestBody SubTaskRequest subTaskRequest) {
        ApiResponse<SubTaskResponse> response = new ApiResponse<>(
                "Create SubTask successfully",
                HttpStatus.CREATED,
                subTaskService.createSubTask(taskId, subTaskRequest),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SubTaskResponse>> updateSubTask(@PathVariable Long id, @RequestBody SubTaskRequest subTaskRequest) {
        ApiResponse<SubTaskResponse> response = new ApiResponse<>(
                "Update SubTask successfully",
                HttpStatus.OK,
                subTaskService.updateSubTask(id, subTaskRequest),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<SubTaskResponse>> deleteSubTask(@PathVariable Long id) {
        subTaskService.deleteSubTask(id);
        ApiResponse<SubTaskResponse> response = new ApiResponse<>(
                "Delete SubTask successfully",
                HttpStatus.OK,
                null,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<ApiResponse<List<SubTaskResponse>>> getAllSubTasks(@PathVariable Long taskId) {
        ApiResponse<List<SubTaskResponse>> response = new ApiResponse<>(
                "Get all SubTasks successfully",
                HttpStatus.OK,
                subTaskService.getAllSubTasks(taskId),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
}
