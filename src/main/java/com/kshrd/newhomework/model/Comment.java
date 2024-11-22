package com.kshrd.newhomework.model;

import com.kshrd.newhomework.model.dto.response.CommentResponse;
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
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public CommentResponse toResponse() {
        return new CommentResponse(this.id, this.content);
    }
}
