package br.com.curseiros.exceptions;

public class CursoFoundException extends RuntimeException {
    public CursoFoundException() {
        super("Curso já cadastrado no sistema");
    }
}
