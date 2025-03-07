package juego;

import java.util.Objects;

/**
 * Clase Workers organización PinkGuards. Tienen department específico y supervisor asignado (rango superior).
 */
import enums.Department;
import excepciones.InvalidSupervisorException;

public class Workers extends PinkGuards {
	private Department department;
	private PinkGuards supervisor;

	/**
	 * Constructor Worker nombre, department y supervisor (rango mayor que Worker):
	 * @param name nombre Worker
	 * @param department departamento de pertenencia
	 * @param supervisor Supervisor asignado
	 * @throws InvalidSupervisorException si rango Supervisor es igual o menor a Worker
	 */
	public Workers(String name, Department department, PinkGuards supervisor) throws InvalidSupervisorException {

	public Workers(String name, Department department) {
		super(name);
		this.department = department;
	}

	/**
	 * Devuelve department del Worker:
	 * 
	 * @return department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Establece departamento Worker:
	 * 
	 * @param department nuevo departamento
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * Devuelve supervisor del Worker:
	 * 
	 * @return supervisor
	 */
	public PinkGuards getSupervisor() {
		return supervisor;
	}

	/**
	 * Devuelve Supervisor del Worker:
	 * 
	 * @return supervisor (a asignar)
	 * @throws InvalidSupervisorException si Supervisor igual o menor rango
	 */
	public void setSupervisor(PinkGuards supervisor) throws InvalidSupervisorException {
		if (supervisor == null) {
			this.supervisor = null;
		} else {
			if (supervisor.getRank() <= this.getRank()) {
				throw new InvalidSupervisorException("Supervisor debe tener mayor rango que Worker.");
			}
			this.supervisor = supervisor;
		}
	}

	@Override
	public int getRank() {
		return 1;
	}

	@Override
	public String toString() {
		String info = "Worker | Nombre: %s | Departamento: %s";
		if (supervisor != null) {
			info += " | Supervisor: %s";
			return String.format(info, name, department, supervisor.name);
		}
		return String.format(info, name, department);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Workers))
			return false;
		Workers workers = (Workers) o;
		return department == workers.department && Objects.equals(getName(), workers.getName())
				&& Objects.equals(supervisor, workers.supervisor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), department, supervisor);
	}

	@Override
	protected boolean contains(PinkGuards members) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void add(PinkGuards members) {
		// TODO Auto-generated method stub

	}

}
