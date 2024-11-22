package com.kshrd.newhomework.controller;

import com.kshrd.newhomework.model.apiresponse.ApiResponse;
import com.kshrd.newhomework.model.dto.request.ProjectRequest;
import com.kshrd.newhomework.model.dto.response.ProjectResponse;
import com.kshrd.newhomework.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    private ResponseEntity<ApiResponse<ProjectResponse>> createProject(@RequestBody ProjectRequest projectRequest) {
        ApiResponse<ProjectResponse> response = new ApiResponse<>(
                "Create project successfully",
                HttpStatus.CREATED,
                projectService.createProject(projectRequest),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectResponse>> getProject(@PathVariable Long id) {
        ApiResponse<ProjectResponse> response = new ApiResponse<>(
                "Get project successfully",
                HttpStatus.OK,
                projectService.getProject(id),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectResponse>> updateProject(@PathVariable Long id, @RequestBody ProjectRequest projectRequest) {
        ApiResponse<ProjectResponse> response = new ApiResponse<>(
                "Update project successfully",
                HttpStatus.OK,
                projectService.updateProject(id, projectRequest),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectResponse>> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        ApiResponse<ProjectResponse> response = new ApiResponse<>(
                "Delete project successfully",
                HttpStatus.OK,
                null,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjectResponse>>> getAllProjects() {
        ApiResponse<List<ProjectResponse>> response = new ApiResponse<>(
                "Get all projects successfully",
                HttpStatus.OK,
                projectService.getAllProjects(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
