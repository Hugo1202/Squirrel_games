package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase Soldiers organización PinkGuards. Tienen WeaponType específico y registran munition disponible. Supervisor de rango superior.
 */
import enums.WeaponType;
import excepciones.InvalidSupervisorException;

public class Soldiers extends PinkGuards {
	private WeaponType weapon;
	private int munition;
	private PinkGuards supervisor;
	private List<PinkGuards> team;

	/**
	 * Constructor Soldier nombre, WeaponType, munition y Supervisor:
	 * @param name nombre Soldier
	 * @param weapontype tipo de arma
	 * @param munition cantidad de munición disponible
	 * @param supervisor supervisor asignado
	 * @throws InvalidSupervisorException si rango Supervisor es igual o menor a Soldier
	 */

	public Soldiers(String name, WeaponType weapon, int munition) {
		super(name);
		this.weapon = weapon;
		this.munition = munition;
		this.team = new ArrayList<>();
	}

	/**
	 * Devuelve WeaponType:
	 * 
	 * @return tipo de arma
	 */
	public WeaponType getWeapon() {
		return weapon;
	}

	/**
	 * Establece WeaponType Soldier:
	 * 
	 * @return weapontype
	 */
	public void setWeapon(WeaponType weapon) {
		this.weapon = weapon;
	}

	/**
	 * Devuelve munition disponible:
	 * 
	 * @return munition
	 */
	public int getMunition() {
		return munition;
	}

	/**
	 * Establece cantidad disponible de munition:
	 * 
	 * @param munition cantidad disponible
	 */
	public void setMunition(int munition) {
		this.munition = munition;
	}

	/**
	 * Devuelve supervisor del Soldier:
	 * 
	 * @return supervisor
	 */
	public PinkGuards getSupervisor() {
		return supervisor;
	}

	/**
	 * Devuelve Supervisor del Soldier:
	 * 
	 * @return supervisor (a asignar)
	 * @throws InvalidSupervisorException si Supervisor igual o menor rango
	 */
	public void setSupervisor(PinkGuards supervisor) throws InvalidSupervisorException {
		if (supervisor == null) {
			this.supervisor = null;
		} else {
			if (supervisor.getRank() <= this.getRank()) {
				throw new InvalidSupervisorException("Supervisor debe tener mayor rango que " + getName() + ".");
			}
			this.supervisor = supervisor;
		}
	}

	public void addTeamMember(PinkGuards member) {
		if (member != null) {
			this.team.add(member);
		}
	}

	@Override
	public int getRank() {
		return 2;
	}

	@Override
	public String toString() {
		String info = "Soldier | Nombre: %s | Arma: %s | Munición: %d";
		if (supervisor != null) {
			info += " | Supervisor: %s";
			return String.format(info + " | Equipo: %d miembros", name, weapon, munition, supervisor.name, team.size());
		}
		return String.format(info + " | Equipo: %d miembros", name, weapon, munition, team.size());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Soldiers))
			return false;
		Soldiers soldiers = (Soldiers) o;
		return munition == soldiers.munition && weapon == soldiers.weapon
				&& Objects.equals(getName(), soldiers.getName()) && Objects.equals(supervisor, soldiers.supervisor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), weapon, munition, supervisor);
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
