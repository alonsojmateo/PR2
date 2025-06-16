package ort.pr.dos.tpfinal.models;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private int dni;
    private int telefono;

    public Persona(String nombre, String apellido, String email, int dni, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public int getDni() {
        return dni;
    }

    public int getTelefono() {
        return telefono;
    }
}
