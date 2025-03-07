package juego;

import java.util.ArrayList;
import java.util.List;

import excepciones.InvalidSupervisorException;
import excepciones.OrganizationException;

public class Organization {
	private List<PinkGuards> members;

	public Organization() {
		this.members = new ArrayList<>();
	}

	public void registerManager(Managers manager) throws OrganizationException {
		if (manager == null) {
			throw new OrganizationException("El Manager no puede ser nulo.");
		}
		if (this.members.contains(manager)) {
			throw new OrganizationException("El Manager ya se encuentra registrado en la organización.");
		}
		this.members.add(manager);
	}

	public void assignSupervisor(PinkGuards supervisor, PinkGuards subordinate) throws OrganizationException {
		try {
			if (subordinate == null || supervisor == null) {
				throw new OrganizationException("Los miembros no pueden ser nulos.");
			}
			if (!members.contains(subordinate)) {
				throw new OrganizationException("El miembro subordinate no está registrado en la organización.");
			}
			if (!members.contains(supervisor)) {
				throw new OrganizationException("El supervisor no está registrado en la organización.");
			}
			if (subordinate instanceof Managers) {
				throw new OrganizationException("Un Manager no puede tener supervisor.");
			}
			if (hasCycle(subordinate, supervisor)) {
				throw new OrganizationException("Asignación cíclica detectada: '" + supervisor.getName()
						+ "' ya supervisa, directa o indirectamente, a '" + subordinate.getName() + "'.");
			}
		} catch (OrganizationException e) {
			System.err.println(e.getMessage());
		}

		try {
			if (subordinate instanceof Workers) {
				((Workers) subordinate).setSupervisor(supervisor);

			} else if (subordinate instanceof Soldiers) {
				((Soldiers) subordinate).setSupervisor(supervisor);
			}
		} catch (InvalidSupervisorException e) {
			System.err.println("Error al asignar supervisor: " + e.getMessage());
		}
	}

	private boolean hasCycle(PinkGuards subordinate, PinkGuards candidateSupervisor) {
		PinkGuards current = candidateSupervisor;
		while (current != null) {
			if (current.equals(subordinate)) {
				return true;
			}
			if (current instanceof Managers) {
				break;
			} else if (current instanceof Workers) {
				current = ((Workers) current).getSupervisor();
			} else if (current instanceof Soldiers) {
				current = ((Soldiers) current).getSupervisor();
			} else {
				break;
			}
		}
		return false;
	}

	public void addTeamMember(PinkGuards managers, PinkGuards subordinate) throws OrganizationException {
		try {
			if (!members.contains(subordinate)) {
				members.add(subordinate);
			}
			if (managers == null || subordinate == null) {
				throw new OrganizationException("Los miembros no pueden ser nulos.");
			}
			if (!members.contains(managers)) {
				throw new OrganizationException("El Manager no está registrado en la organización.");
			}
			if (subordinate instanceof Managers) {
				throw new OrganizationException(
						"No se puede asignar un Manager como miembro del equipo de otro Manager.");
			}
			if (managers instanceof Soldiers && !(subordinate instanceof Workers)) {
				throw new OrganizationException("Un Soldier solo puede supervisar Workers.");
			}
			if (managers instanceof Managers && !(subordinate instanceof Soldiers || subordinate instanceof Workers)) {
				throw new OrganizationException("Un Manager solo puede supervisar Soldiers o Workers.");
			}
			for (PinkGuards member : members) {
				if (member instanceof Managers) {
					Managers mgr = (Managers) member;
					if (mgr != managers && mgr.getTeam().contains(subordinate)) {
						throw new OrganizationException("El miembro ya está asignado al equipo de otro Manager.");
					}
				}
			}

			
			if (managers instanceof Managers) {
				((Managers) managers).addTeamMember(subordinate);

			} else if (managers instanceof Soldiers) {
				((Soldiers) managers).addTeamMember(subordinate);
			}
			assignSupervisor(managers, subordinate);
		} catch (OrganizationException e) {
			System.err.println(e.getMessage());
		}
	}

	public PinkGuards getMember(String name) {
		for (PinkGuards member : members) {
			if (member.getName().equals(name)) {
				return member;
			}
		}
		return null;
	}

	public List<PinkGuards> getMembers() {
		return new ArrayList<>(members);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Organización:");
		for (PinkGuards member : members) {
			sb.append("\n").append(member);
		}
		return sb.toString();
	}
	

}
