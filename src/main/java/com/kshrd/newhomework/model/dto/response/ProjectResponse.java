package com.kshrd.newhomework.model.dto.response;

import com.kshrd.newhomework.model.Project;


public record ProjectResponse(Long id, String name, String description) {

    public Project toEntity() {
        return new Project(id, name, description, null);
    }

}
