package com.flipkart.ecommerce_backend.Exception;

import com.flipkart.ecommerce_backend.api.models.GenericResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error ->{
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName,errorMessage);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

	@ExceptionHandler
	public ResponseEntity<GenericResponseBody> userDoesNotExistsException(UserDoesNotExistsException ex){
		return new ResponseEntity<GenericResponseBody>(HttpStatus.NOT_FOUND);

	}

}
