package juego;

/**
 * Clase abstracta miembro organización PinkGuards.
 */
public abstract class PinkGuards {
	protected String name;

	/**
	 * Constructor PinkGuard con nombre:
	 * @param name nombre miembro
	 */
	public PinkGuards(String name) {
		this.name = name;
	}

	/**
	 * Devuelve nombre mimebro:
	 * @return nombre
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece nuevo nombre:
	 * @param name nuevo nombre
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Devuelve rango del miembro:
	 * @return rango
	 */
	public abstract int getRank();
	
	@Override
	public String toString() {
		return "PinkGuard {name='"+name+"', rank="+getRank()+"}";
	}

	protected abstract boolean contains(PinkGuards members);

	protected abstract void add(PinkGuards members);

}
