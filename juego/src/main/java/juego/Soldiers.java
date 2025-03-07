package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import enums.WeaponType;
import excepciones.InvalidSupervisorException;

public class Soldiers extends PinkGuards {
	private WeaponType weapon;
	private int munition;
	private PinkGuards supervisor;
	private List<PinkGuards> team;
	

	public Soldiers(String name, WeaponType weapon, int munition)  {
        super(name);
        this.weapon = weapon;
        this.munition = munition;
        this.team = new ArrayList<>();
    }

	public WeaponType getWeapon() {
		return weapon;
	}

	public void setWeapon(WeaponType weapon) {
		this.weapon = weapon;
	}

	public int getMunition() {
		return munition;
	}

	public void setMunition(int munition) {
		this.munition = munition;
	}

	public PinkGuards getSupervisor() {
		return supervisor;
	}

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
		return munition == soldiers.munition && weapon == soldiers.weapon && Objects.equals(getName(), soldiers.getName())
				&& Objects.equals(supervisor, soldiers.supervisor);
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