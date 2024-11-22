package com.kshrd.newhomework.model.dto.response;


import com.kshrd.newhomework.model.enums.ESubTaskStatus;

public record SubTaskResponse(Long id, String title, ESubTaskStatus status) {

}
