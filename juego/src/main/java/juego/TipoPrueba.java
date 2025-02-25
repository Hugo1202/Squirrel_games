package juego;

public enum TipoPrueba {
	LUZ_ROJA_LUZ_VERDE("Luz verde luz roja",  "Correr cuando la muñeca no mire.", 35, 55),
    DALGONA("Dalgona", "Cortar la galleta sin romperla.", 30, 50),
    TIRON_DE_CUERDA("Tiron de cuerda","Ganar un juego de tira y afloja en equipo.", 50, 50);
    
	private final String nombre;
    private final String descripcion;
    private final int minEliminados;
    private final int maxEliminados;
    
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
