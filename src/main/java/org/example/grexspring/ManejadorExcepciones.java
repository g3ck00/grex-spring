package org.example.grexspring;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //?
public class ManejadorExcepciones {

    @ExceptionHandler(HorarioNoPermitidoException.class)
    public ResponseEntity<String> manejarHorario(HorarioNoPermitidoException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> manejarValidacion(MethodArgumentNotValidException ex){
        String mensajeError=ex.getBindingResult().getFieldError().getDefaultMessage();
        String campo=ex.getBindingResult().getFieldError().getField();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(campo+": "+mensajeError);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> manejarFormatoInvalido(HttpMessageNotReadableException ex){
        String mensajeError=ex.getMessage();

        if (mensajeError.contains("LocalTime")){
            return ResponseEntity.badRequest().body("Formato inválido para hora (utilice HH:MM)...");
        }

        if (mensajeError.contains("LocalDate")){
            return ResponseEntity.badRequest().body("Formato inválido para fecha (utilice AAAA-MM-DD)...");
        }

        if (mensajeError.contains("JSON")){
            return ResponseEntity.badRequest().body("Formato de JSON inválido...");
        }

        return ResponseEntity.badRequest().body("Formato de datos inválido...");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarGeneral(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno...");
    }
}
