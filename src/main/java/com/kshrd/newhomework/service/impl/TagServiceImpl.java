package com.kshrd.newhomework.service.impl;

import com.kshrd.newhomework.model.Tag;
import com.kshrd.newhomework.model.Task;
import com.kshrd.newhomework.model.dto.request.TagRequest;
import com.kshrd.newhomework.model.dto.response.TagResponse;
import com.kshrd.newhomework.repository.TagRepository;
import com.kshrd.newhomework.repository.TaskRepository;
import com.kshrd.newhomework.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TaskRepository taskRepository;


    @Override
    public TagResponse createTag(TagRequest tagRequest) {
        return tagRepository.save(tagRequest.toEntity()).toResponse();
    }

    @Override
    public List<TagResponse> getAllTags() {
        return tagRepository.findAll().stream().map(Tag::toResponse).toList();
    }

    @Override
    public void assignTagToTask(Long taskId, Long tagsId) {
        Tag tag = tagRepository.findById(tagsId).orElseThrow();
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.getTags().add(tag);
        taskRepository.save(task);
    }

    @Override
    public void removeTagFromTask(Long taskId, Long tagsId) {
        Tag tag = tagRepository.findById(tagsId).orElseThrow();
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.getTags().remove(tag);
        taskRepository.save(task);
    }
}
