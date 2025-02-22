package src.excepciones;

public class IdRepetidoException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public IdRepetidoException(String message) {
        super(message);
    }
}