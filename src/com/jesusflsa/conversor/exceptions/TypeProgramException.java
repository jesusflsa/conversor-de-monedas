package com.jesusflsa.conversor.exceptions;

public class TypeProgramException extends RuntimeException {
    private final String mensaje;

    public TypeProgramException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
