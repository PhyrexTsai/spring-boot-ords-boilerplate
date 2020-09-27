package com.phyrextsai.boilerplate.handler;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import com.phyrextsai.boilerplate.parameter.Response;
import com.phyrextsai.boilerplate.exception.InternalServerErrorException;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class ApplicationExceptionHandler {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @ExceptionHandler(ConstraintViolationException.class)
  public Object constraintViolationExceptionHandler(final ConstraintViolationException e) {
    log.debug("[EXCEPTION] ConstraintViolationException");
    final Response response = new Response();
    response.setError_code("ERR-10400");
    response.setError_message(e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Object methodArgumentNotValidExceptionHandler(final MethodArgumentNotValidException e) {
    log.debug("[EXCEPTION] MethodArgumentNotValidException");
    StringBuilder message = new StringBuilder();
 
    e.getBindingResult().getFieldErrors().forEach(error -> 
      message.append(error.getDefaultMessage()));
     
    final Response response = new Response();
    response.setError_code("ERR-10400");
    response.setError_message(message.toString());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(TypeMismatchException.class)
  public Object typeMismatchExceptionHandler(final TypeMismatchException e) {
    log.debug("[EXCEPTION] TypeMismatchException");
    final Response response = new Response();
    response.setError_code("ERR-10400");
    response.setError_message(e.getValue().toString());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(WebExchangeBindException.class)
  public Object webExchangeBindExceptionHandler(final WebExchangeBindException e) {
    log.debug("[EXCEPTION] WebExchangeBindException");
    final Response response = new Response();
    response.setError_code("ERR-10400");
    response.setError_message(e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
  
  @ExceptionHandler(InternalServerErrorException.class)
  public Object internalServerErrorExceptionHandler(final InternalServerErrorException e) {
    log.debug("[EXCEPTION] InternalServerErrorException");
    final Response response = new Response();
    response.setError_code(e.getErrorCode());
    response.setError_message(e.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }

  @ExceptionHandler(Exception.class)
  public Object exceptionHandler(final Exception e) {
    log.error("[EXCEPTION] Name: {}, Message: {}, Cause: {}", e.getClass().getName(), e.getMessage(), (e.getCause() != null) ? e.getCause() : "NULL");
    final Response response = new Response();
    response.setError_code("ERR-99999");
    response.setError_message("Internal server error");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }

}
