package com.kshrd.newhomework.model;

import com.kshrd.newhomework.model.dto.response.SubTaskResponse;
import com.kshrd.newhomework.model.enums.ESubTaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subtasks")
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private ESubTaskStatus status;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public SubTaskResponse toResponse() {
        return new SubTaskResponse(this.id, this.title, this.status);
    }
}
