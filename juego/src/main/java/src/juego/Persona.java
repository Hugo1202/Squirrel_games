package src.juego;

import java.time.LocalDate;

public abstract class Persona {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String nacionalidad;


    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento, String sexo, String nacionalidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }


    @Override
    public String toString() {
        String info = """
            Nombre: %s
            Apellidos: %s
            Fecha de Nacimiento: %s
            Sexo: %s
            Nacionalidad: %s
            """;
        return String.format(info, nombre, apellidos, fechaNacimiento, sexo, nacionalidad);
    }

}
