package testJuego;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enums.*;
import enums.WeaponType;
import enums.Department;
import excepciones.*;
import juego.*;

public class TestJuego {
	private static Juego game;
	private static Organization organization;
	private static Participantes j1, j2, j3, j4, j5, j6, j7, j8, j9, j10;
	private static Prueba p1, p2, p3;
	private static Managers m, m2;
	private static Soldiers g1, g2, g3, g4;
	private static Workers t1, t2, t3;

	@BeforeEach
	public void SetUp() {
		System.out.println("Inicializando recursos compartidos para todas las pruebas.");
		game = new Juego("Oclajoma", LocalDate.of(2025, 2, 28), 10000);
		organization = new Organization();

		m = new Managers("Manager1", 102, null);
		m2 = new Managers("Manager2", 102, null);
		g1 = new Soldiers("Guardia1", WeaponType.PISTOLA_GLOCK_17, 100);
		g2 = new Soldiers("Guardia2", WeaponType.RIFLE_AUTOMATICO_HECKLER_Y_KOCH_G3, 80);
		g3 = new Soldiers("Guardia3", WeaponType.PISTOLA_GLOCK_17, 100);
		g4 = new Soldiers("Guardia4", WeaponType.RILE_DE_ASALTO_HECKLER_Y_KOCH_MP5, 80);
		t1 = new Workers("Trabajador1", Department.LIMPIEZA_DE_ELIMINADOS);
		t2 = new Workers("Trabajador2", Department.DISTRIBUCION_DE_ALIMENTOS);
		t3 = new Workers("Trabajador3", Department.PREPARACION_DE_JUEGOS);
		

		j1 = new Participantes("pollo", "peel", LocalDate.of(2000, 12, 28), EnumSexo.MASCULINO, "Cakahuense", 700.7);
		j2 = new Participantes("patata", "peel", LocalDate.of(2000, 2, 29), EnumSexo.MASCULINO, "Cakahuense", 700.7);
		j3 = new Participantes("naranja", "peel", LocalDate.of(2000, 2, 29), EnumSexo.MASCULINO, "Cakahuense", 700.7);
		j4 = new Participantes("paja", "peel", LocalDate.of(2000, 12, 28), EnumSexo.MASCULINO, "ohioyense", 700.7);
		j5 = new Participantes("caballo", "peel", LocalDate.of(2000, 12, 28), EnumSexo.MASCULINO, "ohioyense", 700.7);
		j6 = new Participantes("cabra", "peel", LocalDate.of(2000, 12, 28), EnumSexo.MASCULINO, "ohioyense", 700.7);
		j7 = new Participantes("Jugador 1", "Uno", LocalDate.of(1995, 1, 1), EnumSexo.MASCULINO, "España", 500);
		j8 = new Participantes("Jugador 2", "Dos", LocalDate.of(1996, 2, 2), EnumSexo.FEMENINO, "México", 600);
		j9 = new Participantes("Jugador 3", "Tres", LocalDate.of(1997, 3, 3), EnumSexo.FEMENINO, "Argentina", 700);
		j10 = new Participantes("Jugador 4", "Cuatro", LocalDate.of(1998, 4, 4), EnumSexo.FEMENINO, "Chile", 800);
		p1 = new Prueba(TipoPrueba.LUZ_ROJA_LUZ_VERDE);
		p2 = new Prueba(TipoPrueba.DALGONA);
		p3 = new Prueba(TipoPrueba.TIRON_DE_CUERDA);

		game.agregarParticipante(j1);
		game.agregarParticipante(j2);
		game.agregarParticipante(j3);
		game.agregarParticipante(j4);
		game.agregarParticipante(j5);
		game.agregarParticipante(j6);
		game.agregarParticipante(j7);
		game.agregarParticipante(j8);
		game.agregarParticipante(j9);
		game.agregarParticipante(j10);
		game.agregarPrueba(p1);
		game.agregarPrueba(p2);
		game.agregarPrueba(p3);
	}

	@Test
	public void testGetPruebaActual() {
		assertEquals(0, game.getPruebaActual());
	}

	@Test
	public void testGetPruebaAnterior() {
		assertEquals(0, game.getPruebaAnterior());
		game.setPruebaActual(1);
		assertEquals(0, game.getPruebaAnterior());
	}

	@Test
	public void testGetPruebaSiguiente() {
		assertEquals(1, game.getPruebaSiguiente());
		game.setPruebaActual(3);
		assertEquals(3, game.getPruebaSiguiente());
	}

	@Test
	void testAgregarParticipante() {
		Participantes nuevo = new Participantes("Luis", "perez", LocalDate.of(1998, 4, 4), EnumSexo.FEMENINO, "Chile", 800);
		game.agregarParticipante(nuevo);
		assertTrue(game.getParticipantes().contains(nuevo));
	}

	@Test
	void testEliminarParticipante() throws InfiltradoNoEliminableException {
		
		Participantes nuevo = new Participantes("Luis", "perez", LocalDate.of(1998, 4, 4), EnumSexo.FEMENINO, "Chile", "infiltrado1");
		InfiltradoNoEliminableException exception = assertThrows(InfiltradoNoEliminableException.class, 
			    () -> nuevo.eliminar(), 
			    "participante infiltrado no debe ser eliminado");
		 assertEquals("No se puede eliminar al jugador infiltrado Luis.", exception.getMessage());
		assertDoesNotThrow( 
			    () -> j1.eliminar(), 
			    "participante infiltrado no debe ser eliminado");
		j1.eliminar();
		assertTrue(j1.isEliminado());
		
	}

	@Test
	void testJugarRonda() {
		int participantesIniciales = game.getListaParticipantesVivos().size();
		game.jugarRonda(m);
		int participantesDespues = game.getListaParticipantesVivos().size();

		assertTrue(participantesDespues < participantesIniciales, "Debería haber eliminados tras una ronda");
		assertEquals(1, game.getPruebaActual(), "La ronda actual debería haber aumentado a 1");
	}

	@Test
	void testGetParticipantesVivos() throws InfiltradoNoEliminableException {
		j1.eliminar();
		String vivos = game.getParticipantesVivos();
		assertFalse(vivos.contains("Juan"), "Juan debería estar eliminado");
	}

	@Test
	void testGetParticipantesMuertos()  {
		try {
			j2.eliminar();
			j3.eliminar();
		} catch (InfiltradoNoEliminableException e) {
			System.err.println(e.getMessage());
		}
		String muertos = game.getParticipantesMuertos();
		assertTrue(muertos.contains("patata") && muertos.contains("naranja"), "patata y naranja deberían estar eliminados");
	}

	@Test
	void testMostrarPruebas() {
		String pruebas = game.mostrarPruebas();
		assertEquals(pruebas, "LUZ_ROJA_LUZ_VERDE: Correr cuando la muñeca no mire.\nDALGONA: Cortar la galleta sin romperla.\nTIRON_DE_CUERDA: Ganar un juego de tira y afloja en equipo.\n");

	}

	@Test
	public void testSimularPrueba() {
		Prueba prueba = game.getPruebas().get(game.getPruebaActual());
		game.jugarRonda(m);
		double minPorcentaje = (double) prueba.getTipo().getMinEliminados() / 100;
		double maxPorcentaje = (double) prueba.getTipo().getMaxEliminados() / 100;
		int minEliminados = (int) (prueba.getInscritos().size() * minPorcentaje);
		int maxEliminados = (int) (prueba.getInscritos().size() * maxPorcentaje);

		assertEquals(10, prueba.getInscritos().size(), "Todos los participantes deben estar inscritos");
		assertTrue(prueba.getEliminados().size() >= minEliminados && prueba.getEliminados().size() <= maxEliminados,
				"Debe haber entre " + minEliminados + " y " + maxEliminados + " eliminados");
		assertEquals(10 - prueba.getEliminados().size(), prueba.getVencedores().size(),
				"Los vencedores no deben ser los eliminados");

		prueba = game.getPruebas().get(game.getPruebaActual());
		ArrayList<Participantes> pVivos = (ArrayList<Participantes>) game.getListaParticipantesVivos();
		game.jugarRonda(m);
		minPorcentaje = (double) prueba.getTipo().getMinEliminados() / 100;
		maxPorcentaje = (double) prueba.getTipo().getMaxEliminados() / 100;
		minEliminados = (int) (prueba.getInscritos().size() * minPorcentaje);
		maxEliminados = (int) (prueba.getInscritos().size() * maxPorcentaje);

		assertEquals(pVivos, prueba.getInscritos(), "Todos los participantes vivos deben estar inscritos");
		assertTrue(prueba.getEliminados().size() >= minEliminados && prueba.getEliminados().size() <= maxEliminados,
				"Debe haber entre " + minEliminados + " y " + maxEliminados + " eliminados");
		assertEquals(game.getListaParticipantesVivos(), prueba.getVencedores(),
				"Los vencedores deben ser los participantes vivos");

		prueba = game.getPruebas().get(game.getPruebaActual());
		pVivos = (ArrayList<Participantes>) game.getListaParticipantesVivos();
		game.jugarRonda(m);
		minPorcentaje = (double) prueba.getTipo().getMinEliminados() / 100;
		maxPorcentaje = (double) prueba.getTipo().getMaxEliminados() / 100;
		minEliminados = (int) (prueba.getInscritos().size() * minPorcentaje);
		maxEliminados = (int) (prueba.getInscritos().size() * maxPorcentaje);

		assertEquals(pVivos, prueba.getInscritos(), "Todos los participantes vivos deben estar inscritos");
		assertTrue(prueba.getEliminados().size() >= minEliminados && prueba.getEliminados().size() <= maxEliminados,
				"Debe haber entre " + minEliminados + " y " + maxEliminados + " eliminados");
		assertEquals(game.getListaParticipantesVivos(), prueba.getVencedores(),
				"Los vencedores deben ser los participantes vivos");

	}

	@Test
	public void testTipoPrueba() {
		Prueba prueba = game.getPruebas().get(game.getPruebaActual());
		assertEquals("Luz verde luz roja", prueba.getTipo().getNombre(), "El nombre no coincide");
		assertEquals("Correr cuando la muñeca no mire.", prueba.getTipo().getDescripcion(),
				"La descripción no coincide");
		assertEquals(30, prueba.getTipo().getMinEliminados(), "El mínimo de eliminados no es correcto");
		assertEquals(65, prueba.getTipo().getMaxEliminados(), "El máximo de eliminados no es correcto");
	}

	@Test
	void testGetParticipantes() {
		assertEquals(10, game.getParticipantes().size(), "La cantidad de participantes no es correcta");
		assertEquals(10000, game.getBoteTotal(), "El bote total no coincide");
		assertEquals("Oclajoma", game.getUbicacion(), "La ubicación no coincide");
		assertEquals(LocalDate.of(2025, 2, 28), game.getFechaEvento(), "La fecha del evento no coincide");
	}
	
	 @Test
	    void testJugarRondaSinParticipantesVivos() {
	        Juego newGame =  new Juego("Oclajoma", LocalDate.of(2025, 2, 28), 10000);
	        newGame.jugarRonda(m);
	        assertEquals(0, newGame.getPruebaActual());
	        
	        Prueba newPrueba = new Prueba(TipoPrueba.LUZ_ROJA_LUZ_VERDE);
	        newGame.agregarPrueba(newPrueba);
	        assertEquals(0, newGame.getPruebaActual());
	    }
	
	@Test
    void testRegisterManager() throws OrganizationException {
        organization.registerManager(m);
        organization.registerManager(m2);
        assertTrue(organization.getMembers().contains(m));
        assertTrue(organization.getMembers().contains(m2));
    }
	
	@Test
    void testRegisterDuplicateManagerThrowsException() throws OrganizationException {
		organization.registerManager(m);
        assertThrows(OrganizationException.class, () -> {
            organization.registerManager(m);
        });
    }
	
	@Test
    void testAssignSupervisor() throws OrganizationException {
        organization.registerManager(m);
        organization.addTeamMember(m, g1);
        assertEquals(m, g1.getSupervisor());
        assertTrue(m.getTeam().contains(g1));
    }
	
	@Test
    void testAddInvalidTeamMemberThrowsException() throws OrganizationException {
		organization.registerManager(m);
    	organization.addTeamMember(m, m2);
    	assertFalse(m.getTeam().contains(m2));
    }
	
	@Test
    void testGetMember() throws OrganizationException {
        organization.registerManager(m);
        assertEquals(m, organization.getMember("Manager1"));
    }

}
