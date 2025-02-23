package src.juego;

public enum TipoPrueba {
	LUZ_ROJA_LUZ_VERDE("Correr cuando la muñeca no mire.", 30, 60),
    DALGONA("Cortar la galleta sin romperla.", 10, 40),
    TIRON_DE_CUERDA("Ganar un juego de tira y afloja en equipo.", 20, 50);
    
    private final String descripcion;
    private final int minEliminados;
    private final int maxEliminados;
    
    TipoPrueba(String descripcion, int minEliminados, int maxEliminados) {
        this.descripcion = descripcion;
        this.minEliminados = minEliminados;
        this.maxEliminados = maxEliminados;
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
