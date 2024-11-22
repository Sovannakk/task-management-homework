package com.kshrd.newhomework.repository;

import com.kshrd.newhomework.model.Comment;
import com.kshrd.newhomework.model.dto.response.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getAllCommentByTaskId(Long taskId);
}
