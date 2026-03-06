package com.alurachallenge.foro.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GestorDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestionarErrores404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity gestionarErrores400(MethodArgumentNotValidException ex){
        var errores = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errores.stream()
                .map(datosErrorValidacion::new)
                .toList());
    }

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity gestionarErroresDeValidacion(ValidacionException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    public record datosErrorValidacion (String campo, String mensaje){
        public datosErrorValidacion(FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }
    }
}
