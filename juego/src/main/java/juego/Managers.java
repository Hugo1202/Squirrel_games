package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Managers extends PinkGuards {
	public static final String DEFAULT_WEAPON = "SMITH_Y_WESSON_MODEL_10";

	private int munition;
	private List<PinkGuards> team;
	private String pruebaResponsable;

	public Managers(String name, int munition, List<PinkGuards> team) {
        super(name);
        this.munition = munition;
        this.team = (team == null) ? new ArrayList<>() : team;
    }

	public int getMunition() {
		return munition;
	}

	public void setMunition(int munition) {
		this.munition = munition;
	}

	public String getWeapon() {
		return DEFAULT_WEAPON;
	}

	public List<PinkGuards> getTeam() {
		return team;
	}

	public void setTeam(List<PinkGuards> team) {
		this.team = (team == null) ? new ArrayList<>() : team;
	}

	public void addTeamMember(PinkGuards member) {
		if (member != null) {
			this.team.add(member);
		}
	}

	public void removeTeamMember(PinkGuards member) {
		this.team.remove(member);
	}

	public String getPruebaResponsable() {
		return pruebaResponsable;
	}

	public void setPruebaResponsable(String pruebaResponsable) {
		this.pruebaResponsable = pruebaResponsable;
	}

	@Override
	public int getRank() {
		return 3;
	}

	@Override
	public String toString() {
		return "Manager{ " + "name= '" + getName() + '\'' + ", munition= " + munition + ", weapon= " + DEFAULT_WEAPON
				+ ", team= " + team + ", pruebaResponsable='" + pruebaResponsable + '\'' + ", rank= " + getRank() + '}';
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
