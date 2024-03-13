package dev.raj.projectstart.controllers;

import dev.raj.projectstart.dtos.ErrorResponseDto;
import dev.raj.projectstart.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvicers {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> raj(Exception exception){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setErrorResponse(exception.getMessage());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
}
