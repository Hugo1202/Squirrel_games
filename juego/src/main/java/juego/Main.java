package juego;

import java.time.LocalDate;

import excepciones.InvalidSupervisorException;
import excepciones.OrganizationException;

public class Main {
	public static void main(String[] args) throws InvalidSupervisorException {
//		Juego game = new Juego("Oclajoma", LocalDate.of(2025, 2, 28), 10000.11);
//		Participantes j1 = new Participantes("pollo", "peel", LocalDate.of(2000, 12, 28), "Ha", "Cakahuense", 700.7);
//		Participantes j2 = new Participantes("patata", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepe");
//		Participantes j3 = new Participantes("naranja", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepa");
//		Participantes j4 = new Participantes("paja", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
//		Participantes j5 = new Participantes("caballo", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
//		Participantes j6 = new Participantes("cabra", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
//		Prueba p1 = new Prueba(TipoPrueba.LUZ_ROJA_LUZ_VERDE);
//		Prueba p2 = new Prueba(TipoPrueba.DALGONA);
//		Prueba p3 = new Prueba(TipoPrueba.TIRON_DE_CUERDA);
//		//p3.eliminar();
////		System.out.println(p1);
////		System.out.println(p2);
////		System.out.println(p3);
//		game.agregarParticipante(j1);
//		game.agregarParticipante(j2);
//		game.agregarParticipante(j3);
//		game.agregarParticipante(j4);
//		game.agregarParticipante(j5);
//		game.agregarParticipante(j6);
//		game.agregarPrueba(p1);
//		game.agregarPrueba(p2);
//		game.agregarPrueba(p3);
////		System.out.println(game);
////		System.out.println(game.mostrarParticipantes());
//		System.out.println(game.mostrarPruebas());
//		game.jugarRonda();
//		game.jugarRonda();
//		game.jugarRonda();
//		System.out.println(game.getPruebas().get(game.getPruebaAnterior()).getTipo().getDescripcion());
////		System.out.println(game.mostrarParticipantes());
////		System.out.println(game.mostrarParticipantesInfiltrados());
//		System.out.println(game.getParticipantesMuertos());
//		System.out.println(game.getParticipantesVivos());
//		System.out.println(game.mostrarParticipantes());
		Organization organization = new Organization();

        // Crear algunos miembros de la organización (guardias)
		PinkGuards manager = new Managers("Manager1", 102, null);
        PinkGuards guardia1 = new Soldiers("Guardia1", WeaponType.PISTOLA_GLOCK_17, 100, manager);
        PinkGuards guardia2 = new Soldiers("Guardia2", WeaponType.RIFLE_AUTOMATICO_HECKLER_Y_KOCH_G3, 80, manager);
        PinkGuards guardia3 = new Workers("Guardia3", Department.LIMPIEZA_DE_ELIMINADOS, guardia1);
//        PinkGuards guardia1;
//		try {
//			guardia1 = new Soldiers("Guardia1", WeaponType.PISTOLA_GLOCK_17, 100, manager);
//		} catch (InvalidSupervisorException e) {
//			e.printStackTrace();
//		}
//        PinkGuards guardia2;
//		try {
//			guardia2 = new Soldiers("Guardia2", WeaponType.RIFLE_AUTOMATICO_HECKLER_Y_KOCH_G3, 80, manager);
//		} catch (InvalidSupervisorException e) {
//			e.printStackTrace();
//		}
//        PinkGuards guardia3;
//		try {
//			guardia3 = new Workers("Guardia3", Department.LIMPIEZA_DE_ELIMINADOS, manager);
//		} catch (InvalidSupervisorException e) {
//			e.printStackTrace();
//		}

        // Registrar los miembros en la organización
        try {
            organization.registerMember(guardia1);
            organization.registerMember(guardia2);
            organization.registerMember(guardia3);
            organization.registerMember(manager);
        } catch (OrganizationException e) {
            System.out.println("Error al registrar miembro: " + e.getMessage());
        }

        try {
            organization.assignSupervisor(guardia1, guardia2);
            organization.assignSupervisor(guardia3, manager);
        } catch (OrganizationException e) {
            System.out.println("Error al asignar supervisor: " + e.getMessage());
        }

        LocalDate fechaEvento = LocalDate.of(2025, 3, 6);
        Juego juego = new Juego("Isla Secreta", fechaEvento, 100000.00);

        Participantes j1 = new Participantes("pollo", "peel", LocalDate.of(2000, 12, 28), "Ha", "Cakahuense", 700.7);
		Participantes j2 = new Participantes("patata", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepe");
		Participantes j3 = new Participantes("naranja", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepa");
		Participantes j4 = new Participantes("paja", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
		Participantes j5 = new Participantes("caballo", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
		Participantes j6 = new Participantes("cabra", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);

		juego.agregarParticipante(j1);
		juego.agregarParticipante(j2);
		juego.agregarParticipante(j3);
		juego.agregarParticipante(j4);
		juego.agregarParticipante(j5);
		juego.agregarParticipante(j6);

        Prueba prueba1 = new Prueba(TipoPrueba.LUZ_ROJA_LUZ_VERDE);
        Prueba prueba2 = new Prueba(TipoPrueba.DALGONA);
        Prueba prueba3 = new Prueba(TipoPrueba.TIRON_DE_CUERDA);

        juego.agregarPrueba(prueba1);
        juego.agregarPrueba(prueba2);
        juego.agregarPrueba(prueba3);

        System.out.println("Estado inicial del juego:");
        System.out.println(juego);
        System.out.println("Participantes iniciales:");
        System.out.println(juego.mostrarParticipantes());

        System.out.println("\nSimulando Rondas...");
        juego.jugarRonda();
        System.out.println(juego);
        System.out.println(juego.getParticipantesVivos());

        juego.jugarRonda();
        System.out.println(juego);
        System.out.println(juego.getParticipantesVivos());

        System.out.println(juego.getParticipantesMuertos());

        System.out.println("Pruebas realizadas:");
        System.out.println(juego.mostrarPruebas());

//        System.out.println(juego.mostrarParticipantesInfiltrados());
        System.out.println(juego.getParticipantesVivos());
        System.out.println(manager);
        System.out.println(guardia1);
        System.out.println(guardia2);
        System.out.println(guardia3);
	}
}
