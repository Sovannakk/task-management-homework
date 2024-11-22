package com.kshrd.newhomework.model;

import com.kshrd.newhomework.model.dto.response.ProjectResponse;
import com.kshrd.newhomework.model.dto.response.TaskResponse;
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
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public ProjectResponse toResponse() {
        return new ProjectResponse(this.id, this.name, this.description);
    }
}
