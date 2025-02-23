package src.juego;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Juego {
	private String ubicacion;
	private LocalDate fechaEvento;
	private List<Participantes> participantes;
//	private List<Pink_guards> guardias;
    private List<Prueba> pruebas;
	private int pruebaActual = 0;
	private double boteTotal; // dinero acumulado segun la cantidad de eliminados

	public Juego(String ubicacion, LocalDate fechaEvento, double boteInicial) {
		this.participantes = new ArrayList<>();
		this.pruebas = new ArrayList<Prueba>();
		this.ubicacion = ubicacion;
		this.fechaEvento = fechaEvento;
		this.boteTotal = boteInicial;
	}

	public List<Participantes> getParticipantes() {
		return participantes;
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
		return pruebaActual;
	}

	public void setPruebaActual(int newPruebaActual) {
		this.pruebaActual = newPruebaActual;
	}

	public void agregarParticipante(Participantes p) {
		this.participantes.add(p);
	}
	
	public void agregarPrueba(Prueba p) {
		this.pruebas.add(p);
	}
	
	public void jugarRonda() {
		this.pruebas.get(pruebaActual).simularPrueba(this.participantes);
		if (this.pruebaActual < this.pruebas.size()) {
			this.pruebaActual++;
		}
	}

	@Override
	public String toString() {
		String info = """
				Ubicacion: %s
				Fecha del evento: %s
				Numero de participantes: %d
				Numero de ronda: %d / %d
				Bote total: %.2f
				""";
		return String.format(info, this.ubicacion, this.fechaEvento, this.participantes.size(), this.pruebaActual, this.pruebas.size(), this.boteTotal);
	}

	public String mostrarParticipantes() {
		String info = "";
		for (int i = 0; i < this.participantes.size(); i++) {
			info += this.participantes.get(i) + "\n";
		}
		return info;
	}
	
	public String mostrarPruebas() {
		String info = "";
		for (int i = 0; i < this.pruebas.size(); i++) {
			info += this.pruebas.get(i).getTipo() + ": " + this.pruebas.get(i).getTipo().getDescripcion() + "\n";
		}
		return info;
	}
}
