package com.kshrd.newhomework.service;

import com.kshrd.newhomework.model.dto.request.TagRequest;
import com.kshrd.newhomework.model.dto.response.TagResponse;

import java.util.List;

public interface TagService {
    TagResponse createTag(TagRequest tagRequest);

    List<TagResponse> getAllTags();

    void assignTagToTask(Long taskId, Long tagsId);

    void removeTagFromTask(Long taskId, Long tagsId);
}
