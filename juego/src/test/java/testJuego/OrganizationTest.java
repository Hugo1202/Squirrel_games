package squirrelGames;

public class OrganizationTest {
	@Test
	public static void main(String[] args) {
        Organization org = new Organization();

        try {
            Managers manager1 = new Managers("Manager1", 1000, null);
            org.registerMember(manager1);

            Soldiers soldier1 = null;
            try {
                soldier1 = new Soldiers("Soldier1", WeaponType.PISTOLA_GLOCK_17, 500, manager1);
            } catch (InvalidSupervisorException e) {
                System.out.println("Error al crear Soldier1: " + e.getMessage());
                return;
            }
            org.registerMember(soldier1);

            Workers worker1 = null;
            try {
                worker1 = new Workers("Worker1", Department.LIMPIEZA_Y_MANTENIMIENTO, manager1);
            } catch (InvalidSupervisorException e) {
                System.out.println("Error al crear Worker1: " + e.getMessage());
                return;
            }
            org.registerMember(worker1);

            Workers worker2 = null;
            try {
                worker2 = new Workers("Worker2", Department.DISTRIBUCION_DE_ALIMENTOS, manager1);
            } catch (InvalidSupervisorException e) {
                System.out.println("Error al crear Worker2: " + e.getMessage());
                return;
            }
            org.registerMember(worker2);

            org.addTeamMember(manager1, soldier1);
            org.addTeamMember(manager1, worker1);
            org.addTeamMember(manager1, worker2);

            System.out.println("=== Miembros registrados en la organización ===");
            for (PinkGuards member : org.getMembers()) {
                System.out.println(member);
            }

            System.out.println("\n=== Equipo de " + manager1.getName() + " ===");
            for (PinkGuards subordinate : manager1.getTeam()) {
                System.out.println(" - " + subordinate.getName());
            }

            org.assignSupervisor(soldier1, manager1);
            System.out.println("\nSupervisor asignado correctamente a Soldier1: " 
                                + soldier1.getSupervisor().getName());

            System.out.println("\nIntentando asignar un supervisor inválido (worker1 como supervisor de soldier1)...");
            org.assignSupervisor(soldier1, worker1);

        } catch (OrganizationException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }

}
