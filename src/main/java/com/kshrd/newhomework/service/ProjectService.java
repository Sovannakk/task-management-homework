package com.kshrd.newhomework.service;

import com.kshrd.newhomework.model.dto.request.ProjectRequest;
import com.kshrd.newhomework.model.dto.response.ProjectResponse;

import java.util.List;

public interface ProjectService {

    ProjectResponse createProject(ProjectRequest projectRequest);

    ProjectResponse getProject(Long id);

    ProjectResponse updateProject(Long id, ProjectRequest projectRequest);

    void deleteProject(Long id);

    List<ProjectResponse> getAllProjects();
}
