package src.juego;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Juego game = new Juego("Oclajoma", LocalDate.of(2025, 2, 28), 10, 10000.11);
		Participantes p1 = new Participantes("paa", "peel", LocalDate.of(2000, 12, 28), "Ha", "Cakahuense", 700.7);
		Participantes p2 = new Participantes("paa", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepe");
		Participantes p3 = new Participantes("paa", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepe");
		//p3.eliminar();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		game.agregarParticipante(p3);
		game.agregarParticipante(p1);
		game.agregarParticipante(p2);
		System.out.println(game);
	}
}
