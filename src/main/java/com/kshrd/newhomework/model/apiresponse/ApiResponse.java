package com.kshrd.newhomework.model.apiresponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ApiResponse<T>(String message, HttpStatus status, @JsonInclude(JsonInclude.Include.NON_NULL) T payload, LocalDateTime timestamp) {
}
