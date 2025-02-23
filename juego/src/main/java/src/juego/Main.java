package src.juego;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Juego game = new Juego("Oclajoma", LocalDate.of(2025, 2, 28), 10000.11);
		Participantes j1 = new Participantes("paa", "peel", LocalDate.of(2000, 12, 28), "Ha", "Cakahuense", 700.7);
		Participantes j2 = new Participantes("paa", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepe");
		Participantes j3 = new Participantes("paa", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepa");
		Participantes j4 = new Participantes("paja", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
		Participantes j5 = new Participantes("caballo", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
		Participantes j6 = new Participantes("cabra", "peel", LocalDate.of(2000, 12, 28), "Ha", "ohioyense", 700.7);
		Prueba p1 = new Prueba(TipoPrueba.LUZ_ROJA_LUZ_VERDE);
		Prueba p2 = new Prueba(TipoPrueba.DALGONA);
		Prueba p3 = new Prueba(TipoPrueba.TIRON_DE_CUERDA);
		//p3.eliminar();
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
		game.agregarParticipante(j1);
		game.agregarParticipante(j2);
		game.agregarParticipante(j3);
		game.agregarParticipante(j4);
		game.agregarParticipante(j5);
		game.agregarParticipante(j6);
		game.agregarPrueba(p1);
		game.agregarPrueba(p2);
		game.agregarPrueba(p3);
		System.out.println(game);
//		System.out.println(game.mostrarParticipantes());
		System.out.println(game.mostrarPruebas());
		game.jugarRonda();
//		game.jugarRonda();
		System.out.println(game);
		System.out.println(game.mostrarParticipantes());
	}
}
