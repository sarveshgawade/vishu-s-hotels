package com.hotel.vishu_hotels.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.vishu_hotels.DTO.StandardResponse;

//  for global error handling.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // exception : if fields are missing
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardResponse<Map<String,String>>> handleValidationErrors(MethodArgumentNotValidException e){
        Map<String,String> errors = new HashMap<>() ;

        e.getBindingResult().getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage()) ;
        });

        StandardResponse<Map<String,String>> response = new StandardResponse<>(
            errors,
            HttpStatus.BAD_REQUEST.value(),
            "Validation failed !",
            false
        ) ;

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST) ;
    }

    // exception: for duplicate entries of unique constraints
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardResponse<String>> handleDuplicateKey (DataIntegrityViolationException e){

        String message = e.getRootCause().getMessage() ;

        StandardResponse<String> response = new StandardResponse<>(
            null ,
            HttpStatus.CONFLICT.value() ,
            message,
            false
        ) ;

        return new ResponseEntity<>(response,HttpStatus.CONFLICT) ;
    }

    // exception : for conflicting values
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<StandardResponse<String>> handleConflictExpection(ConflictException e){
        StandardResponse response = new StandardResponse<>(
            null,
            HttpStatus.CONFLICT.value(),
            e.getMessage(),
            false
        ) ;

        return new ResponseEntity<>(response,HttpStatus.CONFLICT) ;
    }

    // exception: internal server exception
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<StandardResponse<String>> handleInternalError(InternalServerErrorException e){
        StandardResponse response = new StandardResponse<>(
            null,
            HttpStatus.INTERNAL_SERVER_ERROR.value() ,
            e.getMessage(),
            false
        ) ;

        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR) ;
    }

    
    // exception: generic
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardResponse<String>> handleGenericException (Exception e){

        StandardResponse <String> response = new StandardResponse<>(
            null,
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            e.getMessage(),
            false
        ) ;

        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR) ;
    }
}
