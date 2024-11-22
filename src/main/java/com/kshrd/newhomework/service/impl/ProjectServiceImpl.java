package com.kshrd.newhomework.service.impl;

import com.kshrd.newhomework.model.Project;
import com.kshrd.newhomework.model.dto.request.ProjectRequest;
import com.kshrd.newhomework.model.dto.response.ProjectResponse;
import com.kshrd.newhomework.repository.ProjectRepository;
import com.kshrd.newhomework.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest) {
        return projectRepository.save(projectRequest.toEntity()).toResponse();
    }

    @Override
    public ProjectResponse getProject(Long id) {
        return projectRepository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest projectRequest) {
        return projectRepository.save(projectRequest.toEntity(id)).toResponse();
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll().stream().map(Project::toResponse).toList();
    }
}
