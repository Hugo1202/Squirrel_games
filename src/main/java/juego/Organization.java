package juego;

import java.util.ArrayList;
import java.util.List;

import excepciones.InvalidSupervisorException;
import excepciones.OrganizationException;

/**
 * Clase organización PinkGuards. Registro de miembros, asignación supervisores y equipos y detección de jerarquías.
 */
public class Organization {
	private List<PinkGuards> members;

	/**
	 * Crea instancia de la organización.
	 */
	public Organization() {
		this.members = new ArrayList<>();
	}

	/**
	 * Registro nuevos miembros. Valida supervisor y su registro.
	 * @param member miembro a registrar
	 * @throws OrganizationException si membro es nulo, está registrado o supervisor no encontrado
	 */
	public void registerManager(Managers manager) throws OrganizationException {
		if (manager == null) {
			throw new OrganizationException("El Manager no puede ser nulo.");
		}
		if (this.members.contains(manager)) {
			throw new OrganizationException("El Manager ya se encuentra registrado en la organización.");
		}
		this.members.add(manager);
	}

	/**
	 * Asigna supervisor a miembro registrado. Valida existencia y jerarquía.
	 * @param subordinate miembro a supervisar
	 * @param supervisor (a asignar)
	 * @throws OrganizationException si miembro no registrado o no sigue jerarquía
	 */
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
			//Managers no pueden tener supervisor
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

	/**
	 * Verificación si candidateSupervisor como supervisor de subordinate genera ciclo jerárquico
	 * @param subordinate miembro subordinado
	 * @param candidateSupervisor candidato a supervisor
	 * @return true si ciclo, false si no
	 */
	private boolean hasCycle(PinkGuards subordinate, PinkGuards candidateSupervisor) {
		PinkGuards current = candidateSupervisor;
		while (current != null) {
			if (current.equals(subordinate)) {
				return true;
			}
			//Managers no tienen supervisor
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

	/**
	 * Asigna subordinate a equipo de Manager:
	 * @param manager que gestiona subordinate
	 * @param subordinate a asignar en equipo
	 * @throws OrganizationException si miembro no registrado o asignación rompe jerarquía
	 */
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
			//Manager no puede ser subordinate
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
			//Verifica subordinado no asignado a otro Manager
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

	/**
	 * Busca miembro organización por nombre:
	 * @param name nombre miembro
	 * @return instancia PinkGuard encontrado; null si no encontrado
	 */
	public PinkGuards getMember(String name) {
		for (PinkGuards member : members) {
			if (member.getName().equals(name)) {
				return member;
			}
		}
		return null;
	}

	/**
	 * Devuelve lista miembros registrados:
	 * @return lista miembros
	 */
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
