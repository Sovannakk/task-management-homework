package com.kshrd.newhomework.model.dto.request;

import com.kshrd.newhomework.model.Tag;

public record TagRequest(String name) {

    public Tag toEntity() {
        return new Tag(null, name, null);
    }

}
