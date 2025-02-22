package src.excepciones;

public class InfiltradoNoEliminableException extends RuntimeException {
   
	private static final long serialVersionUID = 1L;

	public InfiltradoNoEliminableException(String message) {
        super(message);
    }
}
