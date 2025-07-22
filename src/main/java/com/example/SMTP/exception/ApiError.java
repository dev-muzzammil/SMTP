package com.example.SMTP.exception;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApiError {
	
    private int status;
    private String statusMessage;
    private LocalDateTime timestamp;
    private List<String> errors;
        

}
