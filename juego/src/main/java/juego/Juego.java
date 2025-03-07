package juego;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.InvalidSupervisorException;

/**
 * La clase {@code Juego} es la clase principal del proyecto.
 * 
 * <p>
 * La clase juego es la que se encarga de unir todas las demas clases para
 * realizar la simulación del juego.
 * </p>
 * 
 * 
 * @version 1.0
 * @see Prueba.java
 * @see Participantes
 */

public class Juego {
	private String ubicacion;
	private LocalDate fechaEvento;
	private List<Participantes> participantes;
	private List<List<PinkGuards>> guardias;
	private List<Prueba> pruebas;
	private int pruebaActual = 0;
	private double boteTotal;

	/**
	 * Obtener la información de las caracteristicas del juego.
	 *
	 *
	 * @param ubicacion   donde se realizaran los juegos.
	 * @param fechaEvento cuando se realizara el juego.
	 * @param boteInicial dinero acumulado en el juego.
	 */
	public Juego(String ubicacion, LocalDate fechaEvento, double boteInicial) {
		this.participantes = new ArrayList<>();
		this.pruebas = new ArrayList<Prueba>();
		this.guardias = new ArrayList<List<PinkGuards>>();
		this.ubicacion = ubicacion;
		this.fechaEvento = fechaEvento;
		this.boteTotal = boteInicial;
	}

	public List<Participantes> getParticipantes() {
		return participantes;
	}

	public List<List<PinkGuards>> getGuardias() {
		return guardias;
	}

	public double getBoteTotal() {
		return this.boteTotal;
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
			return pruebaActual - 1;
		} else {
			System.out.println("no hay prueba anterior");
		}
		return pruebaActual;
	}

	public int getPruebaSiguiente() {
		if (this.pruebaActual < this.pruebas.size()) {
			return pruebaActual + 1;
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

	public void agregarTeam(Managers m) {
		this.guardias.add(m.getTeam());
	}

	/**
	 * Simula la ejecución de una ronda de juego.
	 * 
	 * En cada ronda, se simula una prueba utilizando la lista de participantes
	 * vivos. Además, por cada participante eliminado en la prueba, se suman 10.000
	 * € al bote total.
	 * 
	 * El flujo es:
	 * <ol>
	 * <li>Se comprueba si quedan pruebas por jugar, comparando
	 * <code>pruebaActual</code> con el tamaño de la lista de pruebas.</li>
	 * <li>Si hay pruebas pendientes, se ejecuta la prueba actual llamando a
	 * <code>simularPrueba()</code>, pasándole la lista de participantes vivos.</li>
	 * <li>Se calcula el dinero que se añade al bote: 10.000 por cada eliminado en
	 * la prueba.</li>
	 * <li>Se incrementa el contador <code>pruebaActual</code> para avanzar a la
	 * siguiente ronda.</li>
	 * </ol>
	 * 
	 */

	public void jugarRonda(Managers responsable) {
		if (pruebaActual < pruebas.size() && getListaParticipantesVivos().size() > 1) {
			try {
				this.pruebas.get(pruebaActual).setResponsable(responsable);
				responsable.setPruebaResponsable(this.pruebas.get(pruebaActual));
				System.out.println("\nSimulando Rondas...");
				this.pruebas.get(pruebaActual).simularPrueba(getListaParticipantesVivos());
				this.boteTotal += this.pruebas.get(pruebaActual).getEliminados().size() * 10000;
				pruebaActual++;
			} catch (InvalidSupervisorException e) {
				System.err.println("Error al asignar responsble: " + e.getMessage());
			}
		} else {
			System.err.println("No se ajecuto ninguna prueba");
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

	/**
	 * Devuelve la información de todos los participantes.
	 * 
	 * Este método recorre la lista de participantes y muestra la información de
	 * cada uno. El flujo es:
	 * <ol>
	 * <li>Se crea un String vacío llamado 'info'.</li>
	 * <li>Se recorre la lista completa de participantes usando un bucle for.</li>
	 * <li>En cada iteración, se añade la información del participante al String
	 * 'info'.</li>
	 * <li>Cada participante se añade seguido de un salto de línea.</li>
	 * <li>Al finalizar el bucle, se devuelve el String completo con la información
	 * de todos los participantes.</li>
	 * </ol>
	 * 
	 * @return Un String con la información de todos los participantes.
	 */

	public String mostrarParticipantes() {
		String info = "";
		for (int i = 0; i < this.participantes.size(); i++) {
			info += this.participantes.get(i) + "\n";
		}
		return info;
	}

	/**
	 * Devuelve la información de los participantes que siguen vivos (no
	 * eliminados).
	 * 
	 * Este método recorre la lista de participantes y verifica si el participante
	 * no haya sido eliminado.
	 * 
	 * El flujo es:
	 * <ol>
	 * <li>Se crea un String llamado 'vivos' con el texto inicial "Participantes
	 * sobrevivientes:".</li>
	 * <li>Se recorre la lista completa de participantes usando un bucle
	 * for-each.</li>
	 * <li>En cada iteración, se comprueba si el participante no está eliminado con
	 * <code>isEliminado()</code> de la clase {@code Participantes}.</li>
	 * <li>Si no está eliminado, se añade su información al String 'vivos'.</li>
	 * <li>Al finalizar el bucle, se devuelve el String completo con la información
	 * de todos los participantes vivos.</li>
	 * </ol>
	 * 
	 * @return Un String con la información de los participantes sobrevivientes.
	 */

	public String getParticipantesVivos() {
		String vivos = "Participantes sobrevivientes" + ": \n";
		for (Participantes p : participantes) {
			if (!p.isEliminado()) {
				vivos += p + "\n";
			}
		}
		return vivos;
	}

	/**
	 * Devuelve la información de los participantes que han sido eliminados.
	 * 
	 * Este método recorre la lista de participantes y verifica si han sido
	 * eliminados.
	 * 
	 * El flujo es:
	 * <ol>
	 * <li>Se crea un String llamado 'muertos' con el texto inicial "Participantes
	 * eliminados:".</li>
	 * <li>Se recorre la lista completa de participantes usando un bucle
	 * for-each.</li>
	 * <li>En cada iteración, se comprueba si el participante está eliminado con
	 * <code>isEliminado()</code> de la clase {@code Participantes}.</li>
	 * <li>Si está eliminado, se añade su información al String 'muertos'.</li>
	 * <li>Al finalizar el bucle, se devuelve el String completo con la información
	 * de todos los eliminados.</li>
	 * </ol>
	 * 
	 * @return Un String con la información de los participantes eliminados.
	 */

	public String getParticipantesMuertos() {
		String muertos = "Participantes eliminados: \n";
		for (Participantes p : participantes) {
			if (p.isEliminado()) {
				muertos += p + "\n";
			}
		}
		return muertos;
	}

	/**
	 * Devuelve una lista con los participantes que siguen vivos (no eliminados).
	 * 
	 * Este método recorre la lista de participantes y filtra aquellos que no han
	 * sido eliminados,
	 * 
	 * El flujo es:
	 * <ol>
	 * <li>Se crea una lista vacía llamada 'vivos'.</li>
	 * <li>Se recorre la lista completa de participantes usando un bucle
	 * for-each.</li>
	 * <li>En cada iteración, se comprueba si el participante no está eliminado con
	 * <code>isEliminado()</code> de la clase {@code Participantes}.</li>
	 * <li>Si no está eliminado, se añade a la lista 'vivos'.</li>
	 * <li>Al finalizar el bucle, se devuelve la lista 'vivos', que contiene solo
	 * los participantes que no han sido eliminados.</li>
	 * </ol>
	 * 
	 * @return Una lista de los participantes que siguen vivos (no eliminados).
	 */

	public List<Participantes> getListaParticipantesVivos() {
		List<Participantes> vivos = new ArrayList<>();
		for (Participantes p : participantes) {
			if (!p.isEliminado()) {
				vivos.add(p);
			}
		}
		return vivos;
	}

	/**
	 * Muestra la lista de participantes infiltrados.
	 * 
	 * Este método recorre la lista de participantes y muestra la información de los
	 * participantes infiltrados.
	 * 
	 * El flujo es:
	 * <ol>
	 * <li>Se inicializa un String llamado 'info' con el encabezado "Participantes
	 * infiltrados:".</li>
	 * <li>Se recorre la lista de participantes usando un bucle for.</li>
	 * <li>En cada iteración, se verifica si el participante es infiltrado llamando
	 * a <code>isInfiltrado()</code> de la clase {@code Participantes}</li>
	 * <li>Si es infiltrado, se añade al String 'info', seguido de un salto de
	 * línea.</li>
	 * <li>Al finalizar el bucle, se devuelve el String completo con los infiltrados
	 * encontrados.</li>
	 * </ol>
	 * 
	 * @return Un String con la lista de participantes infiltrados.
	 */

	public String mostrarParticipantesInfiltrados() {
		String info = "Participantes infiltrados: \n";
		for (int i = 0; i < this.participantes.size(); i++) {
			if (this.participantes.get(i).isInfiltrado()) {
				info += this.participantes.get(i) + "\n";
			}
		}
		return info;
	}

	/**
	 * Genera y devuelve un listado de todas las pruebas registradas.
	 * 
	 * Este método recorre la lista de pruebas de la clase y devuelve cada prueba y
	 * su descripción.
	 * 
	 * El flujo es:
	 * <ol>
	 * <li>Se inicializa una cadena vacía llamada 'info'.</li>
	 * <li>Se recorre la lista de pruebas utilizando un bucle for.</li>
	 * <li>En cada iteración, se obtiene el tipo de la prueba y su descripción.</li>
	 * <li>Se concatena esta información a la cadena 'info', seguido de un salto de
	 * línea.</li>
	 * <li>Al finalizar el bucle, se devuelve el String completo con la información
	 * de todas las pruebas.</li>
	 * </ol>
	 * 
	 * @return Un String con el listado de todas las pruebas y sus descripciones.
	 */

	public String mostrarPruebas() {
		String info = "";
		for (int i = 0; i < this.pruebas.size(); i++) {
			info += this.pruebas.get(i).getTipo() + ": " + this.pruebas.get(i).getTipo().getDescripcion() + "\n";
			if (this.pruebas.get(i).getResponsable() != null) {
				info += "Con reponsable: " + this.pruebas.get(i).getResponsable().getName() + "\n";
			}
		}
		return info;
	}
}
