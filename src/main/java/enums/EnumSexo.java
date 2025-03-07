package enums;

public enum EnumSexo {
	MASCULINO("M"), FEMENINO("F");

	private final String nombre;
	
	EnumSexo(String string) {
		this.nombre = string;
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
