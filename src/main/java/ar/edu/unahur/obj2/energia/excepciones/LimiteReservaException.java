package ar.edu.unahur.obj2.energia.excepciones;

public class LimiteReservaException extends RuntimeException {
    public LimiteReservaException(String mensaje) {
        super(mensaje);
    }
}
