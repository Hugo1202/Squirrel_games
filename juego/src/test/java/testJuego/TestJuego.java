package testJuego;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import juego.*;


public class TestJuego  {
	private static Juego game;
	private static Participantes j1, j2, j3, j4, j5, j6, j7, j8, j9, j10;
	private static Prueba p1, p2, p3;

	@BeforeEach
	public void SetUp() {
		System.out.println("Inicializando recursos compartidos para todas las pruebas.");
		game = new Juego("Oclajoma", LocalDate.of(2025, 2, 28), 10000.11);
		j1 = new Participantes("pollo", "peel", LocalDate.of(2000, 12, 28), "Ha", "Cakahuense", 700.7);
		j2 = new Participantes("patata", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepe");
		j3 = new Participantes("naranja", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepa");
		j4 = new Participantes("paja", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
		j5 = new Participantes("caballo", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
		j6 = new Participantes("cabra", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
		j7 = new Participantes("Jugador 1", "Uno", LocalDate.of(1995, 1, 1), "Masculino", "España", 500);
        j8 = new Participantes("Jugador 2", "Dos", LocalDate.of(1996, 2, 2), "Femenino", "México", 600);
        j9 = new Participantes("Jugador 3", "Tres", LocalDate.of(1997, 3, 3), "Masculino", "Argentina", 700);
        j10 = new Participantes("Jugador 4", "Cuatro", LocalDate.of(1998, 4, 4), "Femenino", "Chile", 800);
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
    public void testSimularPrueba() {
		Prueba prueba = game.getPruebas().get(game.getPruebaActual());
        game.jugarRonda();
        double minPorcentaje = (double) prueba.getTipo().getMinEliminados() / 100;
        double maxPorcentaje = (double) prueba.getTipo().getMaxEliminados() / 100;
        int minEliminados = (int) (prueba.getInscritos().size() * minPorcentaje);
        int maxEliminados = (int) (prueba.getInscritos().size() * maxPorcentaje);
        
        assertEquals(10, prueba.getInscritos().size(), "Todos los participantes deben estar inscritos");
        assertTrue(prueba.getEliminados().size() >= minEliminados && prueba.getEliminados().size() <= maxEliminados, "Debe haber entre 3 y 6 eliminados");
        assertEquals(10 - prueba.getEliminados().size(), prueba.getVencedores().size(), "Los vencedores deben ser los no eliminados");
        
        prueba = game.getPruebas().get(game.getPruebaActual());
        ArrayList<Participantes> pVivos = (ArrayList<Participantes>) game.getListaParticipantesVivos();
        game.jugarRonda();
        minPorcentaje = (double) prueba.getTipo().getMinEliminados() / 100;
        maxPorcentaje = (double) prueba.getTipo().getMaxEliminados() / 100;
        minEliminados = (int) (prueba.getInscritos().size() * minPorcentaje);
        maxEliminados = (int) (prueba.getInscritos().size() * maxPorcentaje);
        
        assertEquals(pVivos, prueba.getInscritos(), "Todos los participantes vivos deben estar inscritos");
        assertTrue(prueba.getEliminados().size() >= minEliminados && prueba.getEliminados().size() <= maxEliminados, "Debe haber entre 3 y 5 eliminados");
        assertEquals(game.getListaParticipantesVivos(), prueba.getVencedores(), "Los vencedores no deben ser eliminados");
        
        prueba = game.getPruebas().get(game.getPruebaActual());
        pVivos = (ArrayList<Participantes>) game.getListaParticipantesVivos();
        game.jugarRonda();
        minPorcentaje = (double) prueba.getTipo().getMinEliminados() / 100;
        maxPorcentaje = (double) prueba.getTipo().getMaxEliminados() / 100;
        minEliminados = (int) (prueba.getInscritos().size() * minPorcentaje);
        maxEliminados = (int) (prueba.getInscritos().size() * maxPorcentaje);
        
        assertEquals(pVivos, prueba.getInscritos(), "Todos los participantes deben estar inscritos");
        assertTrue(prueba.getEliminados().size() >= minEliminados && prueba.getEliminados().size() <= maxEliminados, "Debe haber entre 5 eliminados");
        assertEquals(game.getListaParticipantesVivos(), prueba.getVencedores(), "Los vencedores deben ser los no eliminados");
        
        
    }
	
//	@Test
//	public void testEliminarParticipante() {
//		Participantes p = new Participantes("Maria", "Lopez", LocalDate.of(1985, 7, 15), "Femenino", "México", 7000);
//		p.eliminar();
//		assertTrue(p.isEliminado());
//	}
}
