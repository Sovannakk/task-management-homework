package com.kshrd.newhomework.model;

import com.kshrd.newhomework.model.dto.response.TagResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    List<Task> tasks = new ArrayList<>();

    public TagResponse toResponse() {
        return new TagResponse(this.id, this.name);
    }
}
