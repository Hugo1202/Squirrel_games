package src.juego;

import java.time.LocalDate;

public class Participantes extends Persona{

	public Participantes(String nombre, String apellidos, LocalDate fechaNacimiento, String sexo, String nacionalidad) {
		super(nombre, apellidos, fechaNacimiento, sexo, nacionalidad);
	}

}
