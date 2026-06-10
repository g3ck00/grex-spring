package org.example.grexspring;

public class HorarioNoPermitidoException extends RuntimeException {
    public HorarioNoPermitidoException(String mensaje){
        super(mensaje);
    }
}
