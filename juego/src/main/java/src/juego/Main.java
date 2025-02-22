package src.juego;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Participantes p1 = new Participantes( "paa", "peel", LocalDate.of(2000, 12, 28), "Ha", "Cakahuense", 700.7);
		Participantes p2 = new Participantes( "paa", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepe");
		Participantes p3 = new Participantes( "paa", "peel", LocalDate.of(2000, 2, 29), "Ha", "Cakahuense", 700.7, "pepe");
		//p3.eliminar();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
}
