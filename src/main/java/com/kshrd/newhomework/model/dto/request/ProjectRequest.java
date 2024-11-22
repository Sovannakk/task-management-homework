package com.kshrd.newhomework.model.dto.request;

import com.kshrd.newhomework.model.Project;

public record ProjectRequest(String name, String description) {

    public Project toEntity() {
        return new Project(null, name, description, null);
    }

    public Project toEntity(Long id) {
        return new Project(id, name, description, null);
    }

}
