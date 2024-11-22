package com.kshrd.newhomework.controller;

import com.kshrd.newhomework.model.apiresponse.ApiResponse;
import com.kshrd.newhomework.model.dto.request.TaskRequest;
import com.kshrd.newhomework.model.dto.response.TaskResponse;
import com.kshrd.newhomework.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    
    private final TaskService taskService;

    @PostMapping
    private ResponseEntity<ApiResponse<TaskResponse>> createTask(@RequestBody TaskRequest taskRequest) {
        ApiResponse<TaskResponse> response = new ApiResponse<>(
                "Create Task successfully",
                HttpStatus.CREATED,
                taskService.createTask(taskRequest),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskResponse>> getTask(@PathVariable Long id) {
        ApiResponse<TaskResponse> response = new ApiResponse<>(
                "Get Task successfully",
                HttpStatus.OK,
                taskService.getTask(id),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskResponse>> updateTask(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {
        ApiResponse<TaskResponse> response = new ApiResponse<>(
                "Update Task successfully",
                HttpStatus.OK,
                taskService.updateTask(id, taskRequest),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskResponse>> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        ApiResponse<TaskResponse> response = new ApiResponse<>(
                "Delete Task successfully",
                HttpStatus.OK,
                null,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TaskResponse>>> getAllTasks() {
        ApiResponse<List<TaskResponse>> response = new ApiResponse<>(
                "Get all Tasks successfully",
                HttpStatus.OK,
                taskService.getAllTasks(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
}
