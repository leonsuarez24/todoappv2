package org.leon.todoapp.exceptions;

import org.leon.todoapp.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageDto> throwNotFoundException(ResourceNotFoundException e){
        return new ResponseEntity<>(new MessageDto(HttpStatus.NOT_FOUND, e.getMessage()) , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AttributeException.class)
    public ResponseEntity<MessageDto> throwAttributeException(AttributeException e){
        return new ResponseEntity<>(new MessageDto(HttpStatus.BAD_REQUEST, e.getMessage()) , HttpStatus.BAD_REQUEST);
    }
}
