package squirrelGames;

import java.util.ArrayList;
import java.util.List;

public class Organization {
	private List<PinkGuards> members;

	public Organization() {
		this.members = new ArrayList<>();
	}

	public void registerMember(PinkGuards members) throws OrganizationException {
		if (members == null) {
			throw new OrganizationException("El miembro no puede ser nulo.");
		}
		if (members.contains(members)) {
			throw new OrganizationException("El miembro ya se encuentra registrado en la organización.");
		}

		if (members instanceof Workers) {
			Workers workers = (Workers) members;
			if (workers.getSupervisor() != null && !members.contains(workers.getSupervisor())) {
				throw new OrganizationException("El supervisor del Worker no está registrado en la organización.");
			}
		} else if (members instanceof Soldiers) {
			Soldiers soldiers = (Soldiers) members;
			if (soldiers.getSupervisor() != null && !members.contains(soldiers.getSupervisor())) {
				throw new OrganizationException("El supervisor del Soldier no está registrado en la organización.");
			}
		}

		members.add(members);
	}

	public void assignSupervisor(PinkGuards subordinate, PinkGuards supervisor) throws OrganizationException {
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

		try {
			if (subordinate instanceof Workers) {
				((Workers) subordinate).setSupervisor(supervisor);
			} else if (subordinate instanceof Soldiers) {
				((Soldiers) subordinate).setSupervisor(supervisor);
			}
		} catch (InvalidSupervisorException e) {
			throw new OrganizationException("Error al asignar supervisor: " + e.getMessage());
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

	public void addTeamMember(Managers managers, PinkGuards subordinate) throws OrganizationException {
		if (managers == null || subordinate == null) {
			throw new OrganizationException("Los miembros no pueden ser nulos.");
		}
		if (!members.contains(managers)) {
			throw new OrganizationException("El Manager no está registrado en la organización.");
		}
		if (!members.contains(subordinate)) {
			throw new OrganizationException("El miembro a asignar no está registrado en la organización.");
		}
		if (subordinate instanceof Managers) {
			throw new OrganizationException("No se puede asignar un Manager como miembro del equipo de otro Manager.");
		}
		for (PinkGuards member : members) {
			if (member instanceof Managers) {
				Managers mgr = (Managers) member;
				if (mgr != managers && mgr.getTeam().contains(subordinate)) {
					throw new OrganizationException("El miembro ya está asignado al equipo de otro Manager.");
				}
			}
		}
		managers.addTeamMember(subordinate);
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

}
