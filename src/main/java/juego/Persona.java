package juego;

import java.time.LocalDate;

import enums.EnumSexo;


/**
 * La clase {@code Persona} representa la estructura básica que deben de tener todas
 * las personas en el juego, sin importar si son participantes, infiltrados o guardias.
 * 
 * @version 1.0
 * @see Participantes
 * @see Pink_Guards
 */


public abstract class Persona {
    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;
    protected EnumSexo sexo;
    protected String nacionalidad;


/**
 * Obtener información de la persona.
 * 
 * @param nombre de la persona.
 * @param apellidos de la persona.
 * @param fechaNacimiento de la persona.
 * @param sexo de la persona.
 * @param nacionalidad de la persona.
 */
    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento, EnumSexo sexo, String nacionalidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public EnumSexo getSexo() {
        return sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }



    @Override
    public String toString() {
        String info = "Nombre: %s | Apellidos: %s | Fecha de Nacimiento: %s | Sexo: %s | Nacionalidad: %s\n";
        return String.format(info, nombre, apellidos, fechaNacimiento, sexo, nacionalidad);
    }

}
