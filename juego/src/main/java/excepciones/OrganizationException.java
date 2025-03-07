package excepciones;

/**
 * Exception lanzada cuando operación inválida en organización.
 */
public class OrganizationException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construye exception:
	 * @param message mensaje error
	 */
	public OrganizationException(String message) {
        super(message);
    }

}
