package com.kshrd.newhomework.controller;

import com.kshrd.newhomework.model.apiresponse.ApiResponse;
import com.kshrd.newhomework.model.dto.request.TagRequest;
import com.kshrd.newhomework.model.dto.response.TagResponse;
import com.kshrd.newhomework.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ResponseEntity<ApiResponse<TagResponse>> createTag(@RequestBody TagRequest tagRequest) {
        ApiResponse<TagResponse> response = new ApiResponse<>(
                "Create Tag successfully",
                HttpStatus.CREATED,
                tagService.createTag(tagRequest),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TagResponse>>> getAllTags() {
        ApiResponse<List<TagResponse>> response = new ApiResponse<>(
                "Get all Tags successfully",
                HttpStatus.OK,
                tagService.getAllTags(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/tasks/{taskId}/tags/{tagsId}")
    public ResponseEntity<ApiResponse<TagResponse>> assignTagToTask(@PathVariable Long taskId, @PathVariable Long tagsId) {
        tagService.assignTagToTask(taskId, tagsId);
        ApiResponse<TagResponse> response = new ApiResponse<>(
                "Assign Tag to Task successfully",
                HttpStatus.OK,
                null,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/tasks/{taskId}/tags/{tagsId}")
    public ResponseEntity<ApiResponse<TagResponse>> removeTagFromTask(@PathVariable Long taskId, @PathVariable Long tagsId) {
        tagService.removeTagFromTask(taskId, tagsId);
        ApiResponse<TagResponse> response = new ApiResponse<>(
                "Remove Tag from Task successfully",
                HttpStatus.OK,
                null,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
