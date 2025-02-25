package juego;

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

	public int getPruebaActual() {
		return pruebaActual;
	}

	public int getPruebaAnterior() {
		if (this.pruebaActual > 0) {
			return pruebaActual-1;
		} else {
			System.out.println("no hay prueba anterior");
		}
		return pruebaActual;
	}

	public int getPruebaSiguiente() {
		if (this.pruebaActual < this.pruebas.size()) {
			return pruebaActual+1;
		} else {
			System.out.println("no hay prueba siguiente");
		}
		return pruebaActual;
	}

	public void setPruebaActual(int newPruebaActual) {
		this.pruebaActual = newPruebaActual;
	}

	public List<Prueba> getPruebas() {
		return pruebas;
	}

	public void agregarParticipante(Participantes p) {
		this.participantes.add(p);
	}

	public void agregarPrueba(Prueba p) {
		this.pruebas.add(p);
	}

	public void jugarRonda() {
        if (pruebaActual < pruebas.size()) {
        	this.pruebas.get(pruebaActual).simularPrueba(getListaParticipantesVivos());
            this.boteTotal += this.pruebas.get(pruebaActual).getEliminados().size() * 1000000;
            pruebaActual++;
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
		return String.format(info, this.ubicacion, this.fechaEvento, this.participantes.size(), this.pruebaActual,
				this.pruebas.size(), this.boteTotal);
	}

	public String mostrarParticipantes() {
		String info = "";
		for (int i = 0; i < this.participantes.size(); i++) {
			info += this.participantes.get(i) + "\n";
		}
		return info;
	}

	public String getParticipantesVivos() {
		String vivos = "Participantes sobrevivientes"
				+ ": \n";
        for (Participantes p : participantes) {
            if (!p.isEliminado()) {
                vivos += p;
            }
        }
        return vivos;
    }

    public String getParticipantesMuertos() {
        String muertos = "Participantes eliminados: \n";
        for (Participantes p : participantes) {
            if (p.isEliminado()) {
                muertos += p;
            }
        }
        return muertos;
    }
    
    public List<Participantes> getListaParticipantesVivos() {
        List<Participantes> vivos = new ArrayList<>();
        for (Participantes p : participantes) {
            if (!p.isEliminado()) {
                vivos.add(p);
            }
        }
        return vivos;
    }

	public String mostrarParticipantesInfiltrados() {
		String info = "Participantes infiltrados: \n";
		for (int i = 0; i < this.participantes.size(); i++) {
			if (this.participantes.get(i).isInfiltrado()) {
				info += this.participantes.get(i) + "\n";
			}
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
