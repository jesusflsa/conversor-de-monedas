package com.jesusflsa.conversor.exceptions;

public class ErrorApiException extends RuntimeException {
    private final String mensaje;

    public ErrorApiException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
