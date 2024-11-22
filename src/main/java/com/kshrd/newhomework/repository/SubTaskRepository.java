package com.kshrd.newhomework.repository;

import com.kshrd.newhomework.model.SubTask;
import com.kshrd.newhomework.model.dto.response.SubTaskResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {

    List<SubTask> findAllByTaskId(Long taskId);


}
