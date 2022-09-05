package br.com.sitesoft.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import br.com.sitesoft.exceptions.ExceptionResponse;
import br.com.sitesoft.exceptions.UnsupportedMathOperationExcetion;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception ex, WebRequest request) {
		
		ExceptionResponse  exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity <>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UnsupportedMathOperationExcetion.class)
	public final ResponseEntity<ExceptionResponse> handlerBadRequestExceptions(Exception ex, WebRequest request) {
		
		ExceptionResponse  exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity <>(exceptionResponse, HttpStatus.BAD_REQUEST); 
		
	}
	
	

}
