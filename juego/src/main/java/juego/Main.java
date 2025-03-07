package juego;

import java.time.LocalDate;

import enums.Department;
import enums.TipoPrueba;
import enums.WeaponType;
import excepciones.OrganizationException;

public class Main {
	public static void main(String[] args) throws OrganizationException {
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
		Organization org = new Organization();

		Managers m= new Managers("Manager1", 102, null);
		Managers m2 = new Managers("Manager2", 102, null);
        Soldiers g11 = new Soldiers("Guardia11", WeaponType.PISTOLA_GLOCK_17, 100);
        Soldiers g21 = new Soldiers("Guardia21", WeaponType.RIFLE_AUTOMATICO_HECKLER_Y_KOCH_G3, 80);
        Soldiers g31 = new Soldiers("Guardia31", WeaponType.PISTOLA_GLOCK_17, 100);
        Soldiers g41 = new Soldiers("Guardia41", WeaponType.RILE_DE_ASALTO_HECKLER_Y_KOCH_MP5, 80);
        Soldiers g1 = new Soldiers("Guardia1", WeaponType.PISTOLA_GLOCK_17, 100);
        Soldiers g2 = new Soldiers("Guardia2", WeaponType.RIFLE_AUTOMATICO_HECKLER_Y_KOCH_G3, 80);
        Soldiers g3 = new Soldiers("Guardia3", WeaponType.PISTOLA_GLOCK_17, 100);
        Soldiers g4 = new Soldiers("Guardia4", WeaponType.RILE_DE_ASALTO_HECKLER_Y_KOCH_MP5, 80);
        Workers t1 = new Workers("Trabajador1", Department.LIMPIEZA_DE_ELIMINADOS );
        Workers t2 = new Workers("Trabajador2", Department.DISTRIBUCION_DE_ALIMENTOS);
        Workers t3 = new Workers("Trabajador3", Department.PREPARACION_DE_JUEGOS);


        try {
        	org.registerManager(m);
        	org.registerManager(m2);
        } catch (OrganizationException e) {
            System.out.println("Error al registrar miembro: " + e.getMessage());
        }
        

//        try {
//            org.assignSupervisor(g1, g2);
//            org.assignSupervisor(t1, m);
//        } catch (OrganizationException e) {
//            System.out.println("Error al asignar supervisor: " + e.getMessage());
//        }
        
        org.addTeamMember(m, t1);
        org.addTeamMember(m, g1);
        org.addTeamMember(m, t2);
        org.addTeamMember(m, g3);
        org.addTeamMember(m, g11);
        org.addTeamMember(t2, g2);
        org.addTeamMember(m, m2);
        org.addTeamMember(g3, g31);
        org.addTeamMember(g11, t3);
        
        

        Juego juego = new Juego("Isla Secreta", LocalDate.of(2025, 3, 6), 100000.00);

        Participantes j1 = new Participantes("pollo", "peel", LocalDate.of(2000, 12, 28), "Ha", "Cakahuense", 700.7);
		Participantes j2 = new Participantes("patata", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 302);
		Participantes j3 = new Participantes("naranja", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 22);
		Participantes j4 = new Participantes("paja", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
		Participantes j5 = new Participantes("caballo", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
		Participantes j6 = new Participantes("cabra", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
		
//		m.addTeamMember(g1);
//        m.addTeamMember(g2);
//        m.addTeamMember(g3);
//        m.addTeamMember(g4);
//        m.addTeamMember(t1);
//        m.addTeamMember(t2);
//        m.addTeamMember(t3);
        
        juego.agregarTeam(m);

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
        
        juego.jugarRonda(m);
//        System.out.println(juego);
//        System.out.println(juego.getParticipantesVivos());
//
        juego.jugarRonda(m);
//        System.out.println(juego);
//        System.out.println(juego.getParticipantesVivos());
//
//        System.out.println(juego.getParticipantesMuertos());
//
//        System.out.println("Pruebas realizadas:");
//        System.out.println(juego.mostrarPruebas());
//
////        System.out.println(juego.mostrarParticipantesInfiltrados());
//        System.out.println(juego.getParticipantesVivos());
        System.out.println(m);
        System.out.println(m2);
        System.out.println(g1);
        System.out.println(g11);
        System.out.println(g2);
        System.out.println(g3);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(org);
        
	}
}
