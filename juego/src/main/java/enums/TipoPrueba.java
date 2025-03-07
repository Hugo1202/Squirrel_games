package enums;

import juego.Prueba;

/**
 * La clase {@code TipoPrueba} representa los tipos de pruebas que se realizaran
 * en los juegos.
 * 
 * <p> Cada prueba tiene diferente probabilidad de muerte </p>
 * 
 * @version 1.0
 * @see Prueba
 * 
 */

public enum TipoPrueba {
	LUZ_ROJA_LUZ_VERDE("Luz verde luz roja",  "Correr cuando la muñeca no mire.", 30, 65),
    DALGONA("Dalgona", "Cortar la galleta sin romperla.", 30, 55),
    TIRON_DE_CUERDA("Tiron de cuerda","Ganar un juego de tira y afloja en equipo.", 50, 50);
    
	private final String nombre;
    private final String descripcion;
    private final int minEliminados;
    private final int maxEliminados;
    
    
    
    /**
     * Obtener información de las pruebas.
     * 
     * @param nombre de la prueba.
     * @param descripcion de la prueba.
     * @param minEliminados, es la cantidad minima de participantes eliminados que debe de tener la prueba.
     * @param maxEliminados, es la cantidad maxima de participantes eliminados que debe de tener la prueba.
     */
    
    TipoPrueba(String nombre, String descripcion, int minEliminados, int maxEliminados) {
    	this.nombre = nombre;
        this.descripcion = descripcion;
        this.minEliminados = minEliminados;
        this.maxEliminados = maxEliminados;
    }
    
    public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
        return descripcion;
    }
    
    public int getMinEliminados() {
        return minEliminados;
    }
    
    public int getMaxEliminados() {
        return maxEliminados;
    }
}
