package src.juego;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Juego {
	private String ubicacion;
	private List<Participantes> participantes;
	private LocalDate fechaEvento;
	private int numMinijuegos; //estoy tentado en hacer un enum pero de momento no lo voy a hacer
	private int minijuegosRestantes;
	private double boteTotal; // dinero acumulado segun la cantidad de eliminados
	
	public Juego(String ubicacion, LocalDate fechaEvento, int numMinijuegos, double boteInicial) {
		this.participantes = new ArrayList<>();
		this.ubicacion = ubicacion;
		this.fechaEvento = fechaEvento;
		this.numMinijuegos = numMinijuegos;
		this.boteTotal = boteInicial;
	}

	public List<Participantes> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participantes> participantes) {
		this.participantes = participantes;
	}

	public int getNumMinijuegos() {
		return numMinijuegos;
	}

	public void setNumMinijuegos(int numMinijuegos) {
		this.numMinijuegos = numMinijuegos;
	}

	public double getBoteTotal() {
		return boteTotal;
	}

	public void setBoteTotal(double boteTotal) {
		this.boteTotal = boteTotal;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public LocalDate getFechaEvento() {
		return fechaEvento;
	}
	
	public int getMinijuegosRestantes() {
		return minijuegosRestantes;
	}

	public void setMinijuegosRestantes(int minijuegosRestantes) {
		this.minijuegosRestantes = minijuegosRestantes;
	}
	
	public void agregarParticipante(Participantes p) {
		this.participantes.add(p);
	}

	@Override
	public String toString() {
		String info = "Ubicacion: " + this.ubicacion + "\n" +
                "Fecha del evento: " + this.fechaEvento + "\n" +
                "Numero de participantes: " + this.participantes.size() + "\n" +
                "Bote total: " + this.boteTotal + "\n" +
				"Numero de ronda: " + this.minijuegosRestantes + "/" + this.numMinijuegos + "\n";
        return info;
	}
}
