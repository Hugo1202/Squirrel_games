package src.juego;

import java.time.LocalDate;
import src.excepciones.InfiltradoNoEliminableException;


public class Participantes extends Persona {
    private int id;
    private double deudaAcumulada;
    private boolean infiltrado;
    private String nombreFalso; 
    private boolean eliminado;
    private static int siguienteId = 1;


    public Participantes(int id, String nombre, String apellidos, LocalDate fechaNacimiento, String sexo, String nacionalidad, double deudaAcumulada) {
        super(nombre, apellidos, fechaNacimiento, sexo, nacionalidad);
        this.id = id;
        this.deudaAcumulada = deudaAcumulada;
        this.infiltrado = false;
        this.eliminado = false;
        this.id = siguienteId++; 
    }


    public Participantes(int id, String nombre, String apellidos, LocalDate fechaNacimiento, String sexo, String nacionalidad, double deudaAcumulada, String nombreFalso) {
        super(nombre, apellidos, fechaNacimiento, sexo, nacionalidad);
        this.id = id;
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


    public void eliminar() throws InfiltradoNoEliminableException {
        if (infiltrado) {
            throw new InfiltradoNoEliminableException("No se puede eliminar a un jugador infiltrado.");
        }
        this.eliminado = true;
    }


    @Override
    public String toString() {
        String info = super.toString();
        info += "ID: " + id + "\n" +
                "Deuda Acumulada: " + deudaAcumulada + "\n" +
                "Infiltrado: " + infiltrado + "\n";
        if (infiltrado) {
            info += "Nombre Falso: " + nombreFalso + "\n";
        }
        info += "Eliminado: " + eliminado + "\n";
        return info;
    }
}
