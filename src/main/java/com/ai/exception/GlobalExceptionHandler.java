package com.ai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.ai.utills.ErrorDetails;

@RestControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler(InvalidDataAccessApiUsageException.class)
	public ResponseEntity<ErrorDetails> InvalidDataAccessApiUsageException(ResourceNotFoundException exception,
			WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
				webRequest.getDescription(false) // Returns the API URI path
		);

		// Returns the payload along with a 404 Not Found HTTP status
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
