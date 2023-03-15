package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import com.example.demo.entity.ErrorMessage;
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException exception,WebRequest request) {
		ErrorMessage message= new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message); 
		}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> otherException(Exception exception,WebRequest request) {
		ErrorMessage message= new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message); 
		}

}
