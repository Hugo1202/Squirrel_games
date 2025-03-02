package juego;

import java.time.LocalDate;

import excepciones.InfiltradoNoEliminableException;

/**
 * La clase {@code Participantes} es una clase hija de la clase {@code Persona}.Se utiliza para poder 
 * utilizar la estructura básica de las personas.
 * 
 * @version 1.0
 * @see Persona
 */

public class Participantes extends Persona {
    private int id;
    private double deudaAcumulada;
    private boolean infiltrado;
    private String nombreFalso; 
    private boolean eliminado;
    private static int siguienteId = 1;


    /**
     * Obtener información de los participantes no infiltrados.
     * 
     * @param nombre del participante.
     * @param apellidos del participante.
     * @param fechaNacimiento del participante.
     * @param sexo del participante.
     * @param nacionalidad del participante.
     * @param deuda acumulada del participante.
     * @param infiltrado, al estar en false nos indica que el participante no es infiltrado.
     * @param eliminado, nos indica si el participante esta eliminado.
     * @param id, nos asegura que nos da un ID unico para cada participante.
     */
    
    public Participantes(String nombre, String apellidos, LocalDate fechaNacimiento, String sexo, String nacionalidad, double deudaAcumulada) {
        super(nombre, apellidos, fechaNacimiento, sexo, nacionalidad);
        this.deudaAcumulada = deudaAcumulada;
        this.infiltrado = false;
        this.eliminado = false;
        this.id = siguienteId++; 
    }

    
    /**
     * Obtener información de los participantes infiltrados.
     * 
     * @param nombre del infiltrado.
     * @param apellidos del infiltrado.
     * @param fechaNacimiento del infiltrado.
     * @param sexo del infiltrado.
     * @param nacionalidad del infiltrado.
     * @param deuda acumulada del infiltrado.
     * @param infiltrado, al estar en true nos indica que es infiltrado.
     * @param nombreFalso del infiltrado.
     * @param eliminado, nos indica si el participante esta eliminado.
     * @param id, nos asegura que nos da un ID unico para cada infiltrado.
     */

    public Participantes(String nombre, String apellidos, LocalDate fechaNacimiento, String sexo, String nacionalidad, double deudaAcumulada, String nombreFalso) {
        super(nombre, apellidos, fechaNacimiento, sexo, nacionalidad);
        this.deudaAcumulada = deudaAcumulada;
        this.infiltrado = true;
        this.nombreFalso = nombreFalso;
        this.eliminado = false;
        this.id = siguienteId++; 
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDeudaAcumulada() {
        return deudaAcumulada;
    }

    public void setDeudaAcumulada(double deudaAcumulada) {
        this.deudaAcumulada = deudaAcumulada;
    }

    public boolean isInfiltrado() {
        return infiltrado;
    }

    public void setInfiltrado(boolean infiltrado) {
        this.infiltrado = infiltrado;
    }

    public String getNombreFalso() {
        return nombreFalso;
    }

    public void setNombreFalso(String nombreFalso) {
        this.nombreFalso = nombreFalso;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

/**
 * Elimina a participantes.
 * 
 * 
 * @throws InfiltradoNoEliminableException si el participante es infiltrado.
 */
    
    
    public void eliminar() throws InfiltradoNoEliminableException {
//        if (infiltrado) {
//            throw new InfiltradoNoEliminableException("No se puede eliminar a un jugador infiltrado.");
//        }
        this.eliminado = true;
    }


    @Override
    public String toString() {
    	String info = "ID: %d | %s";
        if (infiltrado) {
            info += "Infiltrado: %s | Nombre Falso: %s | Eliminado: %s\n";
            return String.format(info, id, super.toString(), String.valueOf(this.infiltrado), this.nombreFalso, String.valueOf(eliminado));
        } else {
        	info += "Deuda Acumulada: %.2f | Eliminado: %s \n";
            return String.format(info, id, super.toString(), deudaAcumulada, String.valueOf(eliminado));
        }
    }
}
