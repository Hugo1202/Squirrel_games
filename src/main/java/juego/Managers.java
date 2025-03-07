package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase Managers de organización PinkGuards. Tienen arma predeterminada, munition y equipo bajo supervisión. Pueden ser responsable pruebas.
 */
public class Managers extends PinkGuards {
	/**
	 * Arma predeterminada
	 */
	public static final String DEFAULT_WEAPON = "SMITH_Y_WESSON_MODEL_10";

	private int munition;
	private List<PinkGuards> team;
	private Prueba pruebaResponsable;

	/**
	 * Constructor Manager con nombre, munición y equipo:
	 * @param name nombre Manager
	 * @param munition cantidad disponible de munición
	 * @param team equipo a su cargo; si null, equipo vacío
	 */
	public Managers(String name, int munition, List<PinkGuards> team) {
        super(name);
        this.munition = munition;
        this.team = (team == null) ? new ArrayList<>() : team;
    }

	/**
	 * Devuelve cantidad de munición Manager:
	 * @return munition
	 */
	public int getMunition() {
		return munition;
	}

	/**
	 * Establece munición del Manager:
	 * @param munition cantidad disponible
	 */
	public void setMunition(int munition) {
		this.munition = munition;
	}

	/**
	 * Devuelve arma Manager:
	 * @return default weapon
	 */
	public String getWeapon() {
		return DEFAULT_WEAPON;
	}

	/**
	 * Devuelve equipo a cargo del Manager:
	 * @return team lista de equipo
	 */
	public List<PinkGuards> getTeam() {
		return team;
	}

	/**
	 * Establece equipo a cargo del Manager:
	 * @param team lista de equipo
	 */
	public void setTeam(List<PinkGuards> team) {
		this.team = (team == null) ? new ArrayList<>() : team;
	}

	/**
	 * Añade miembro a equipo a cargo del Manager:
	 * @param member (a añadir)
	 */
	public void addTeamMember(PinkGuards member) {
		if (member != null) {
			this.team.add(member);
		}
	}

	/**
	 * Elimina miembro de equipo a cargo del Manager:
	 * @param member (a eliminar)
	 */
	public void removeTeamMember(PinkGuards member) {
		this.team.remove(member);
	}

	/**
	 * Devuelve prueba responsabilidad del Manager:
	 * @return prueba asignada; null si no hay
	 */
	public Prueba getPruebaResponsable() {
		return pruebaResponsable;
	}

	/**
	 * Establece prueba responsabilidad del Manager:
	 * @param prueba
	 */
	public void setPruebaResponsable(Prueba prueba) {
		this.pruebaResponsable = prueba;
	}

	@Override
	public int getRank() {
		return 3;
	}

	 @Override
	    public String toString() {
	        return String.format("Manager | Nombre: %s | Munición: %d | Equipo: %d miembros",
	            name,
	            munition,
	            team.size()
	        );
	    }

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Managers))
			return false;
		Managers managers = (Managers) o;
		return munition == managers.munition && Objects.equals(getName(), managers.getName())
				&& Objects.equals(team, managers.team) && Objects.equals(pruebaResponsable, managers.pruebaResponsable);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), munition, team, pruebaResponsable);
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
