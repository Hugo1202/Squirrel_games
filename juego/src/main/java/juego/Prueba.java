package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import enums.TipoPrueba;
import excepciones.InfiltradoNoEliminableException;
import excepciones.InvalidSupervisorException;

/**
 * La clase {@code Prueba} es la encargada de simular la ejecución de la prueba.
 * 
 * @version 1.0
 * @see Juego
 */

public class Prueba {
	private TipoPrueba tipo;
	private List<Participantes> inscritos;
	private List<Participantes> eliminados;
	private List<Participantes> vencedores;
	private PinkGuards responsable;

	/**
	 * Obtener información de los componentes de la prueba.
	 * 
	 * @param tipo,       especifica el tipo de prueba que se realizará.
	 * @param inscritos,  es una lista de los participantes que hay antes de iniciar
	 *                    la prueba.
	 * @param eliminados, es la lista de los participantes que han sido eliminados
	 *                    en la prueba.
	 * @param vencedores, es la lista de los participantes que han superado la
	 *                    prueba.
	 */

	public Prueba(TipoPrueba tipo) {
		this.tipo = tipo;
		this.inscritos = new ArrayList<>();
		this.eliminados = new ArrayList<>();
		this.vencedores = new ArrayList<>();
		this.responsable = null;
	}

	public TipoPrueba getTipo() {
		return tipo;
	}

	public List<Participantes> getInscritos() {
		inscritos.sort(Comparator.comparingInt(Participantes::getId));
		return inscritos;
	}

	public void setInscritos(List<Participantes> inscritos) {
		this.inscritos = inscritos;
	}

	public List<Participantes> getEliminados() {
		eliminados.sort(Comparator.comparingInt(Participantes::getId));
		return eliminados;
	}

	public List<Participantes> getVencedores() {
		vencedores.sort(Comparator.comparingInt(Participantes::getId));
		return vencedores;
	}

	public PinkGuards getResponsable() {
		return responsable;
	}

	public void setResponsable(PinkGuards responsable) throws InvalidSupervisorException {
		if (responsable.getRank() < 3 || responsable == null) {
			throw new InvalidSupervisorException("Supervisor debe tener mayor rango que Soldier.");
		}
		this.responsable = responsable;
	}

	/**
	 * Simula la ejecución de la prueba.
	 * 
	 * Este método toma una lista de participantes y simula una prueba, donde seran
	 * eliminados de manera aleatoria.
	 * 
	 * El flujo es:
	 * <ol>
	 * <li>Se registran los participantes como "inscritos".</li>
	 * <li>Se calcula el porcentaje de eliminados de forma aleatoria, dentro de un
	 * rango permitido.</li>
	 * <li>Se mezclan los inscritos (shuffle) para que la eliminación sea
	 * aleatoria.</li>
	 * <li>Se eliminan los participantes correspondientes al porcentaje de
	 * eliminados</li>
	 * <li>Los eliminados se añaden a la lista de eliminados.</li>
	 * <li>El resto de participantes pasan a la lista de vencedores.</li>
	 * </ol>
	 * 
	 * @param participantes Lista de participantes inscritos en la prueba.
	 */

	public void simularPrueba(List<Participantes> participantes) {
		setInscritos(participantes);
		double porcentajeEliminados = (Math.random() * (tipo.getMaxEliminados() - tipo.getMinEliminados())
				+ tipo.getMinEliminados()) / 100.0;
		int eliminadosObjetivo = (int) (inscritos.size() * porcentajeEliminados);
		Collections.shuffle(inscritos);
		for (int i = 0; i < eliminadosObjetivo; i++) {

			try {
				inscritos.get(i).eliminar();
				eliminados.add(inscritos.get(i));
			} catch (InfiltradoNoEliminableException e) {
				System.err.println(e.getMessage());
			}

		}
		vencedores.addAll(inscritos);
		vencedores.removeAll(eliminados);
	}
}
