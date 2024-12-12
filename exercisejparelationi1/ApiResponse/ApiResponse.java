package com.example.exercisejparelationi1.ApiResponse;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
//@AllArgsConstructor
@RequiredArgsConstructor
public class ApiResponse {
    private String message;

    public ApiResponse(String message) {
        this.message = message;
    }
}