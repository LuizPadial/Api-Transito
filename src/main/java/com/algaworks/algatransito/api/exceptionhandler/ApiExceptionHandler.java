package com.algaworks.algatransito.api.exceptionhandler;

import com.algaworks.algatransito.domain.exception.DomainException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<String> capturar(DomainException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
