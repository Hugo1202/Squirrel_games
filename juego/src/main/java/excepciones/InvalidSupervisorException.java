package squirrelGames;

/**
 * Exception lanzada cuando el supervisor que se intenta asignar es de rango igual o inferior al subordinado.
 */
public class InvalidSupervisorException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construye exception:
	 * @param message mensaje error
	 */
	public InvalidSupervisorException(String message) {
        super(message);
    }

}
