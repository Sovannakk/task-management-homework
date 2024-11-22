package com.kshrd.newhomework.model;

import com.kshrd.newhomework.model.dto.response.TaskResponse;
import com.kshrd.newhomework.model.enums.EPriority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)
    private EPriority priority;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<SubTask> subTasks = new ArrayList<>();

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public TaskResponse toResponse() {
        return new TaskResponse(
                this.id,
                this.title,
                this.description,
                this.priority,
                this.dueDate,
                this.project != null ? this.project.toResponse() : null,
                this.tags != null
                        ? this.tags.stream().map(Tag::toResponse).toList()
                        : List.of(),
                this.subTasks != null
                        ? this.subTasks.stream().map(SubTask::toResponse).toList()
                        : List.of(),
                this.comments != null
                        ? this.comments.stream().map(Comment::toResponse).toList()
                        : List.of()
        );
    }


}
