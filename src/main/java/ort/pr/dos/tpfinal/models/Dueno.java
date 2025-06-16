package ort.pr.dos.tpfinal.models;

import ort.pr.dos.tpfinal.observer.Observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dueno extends Persona implements Observer {
    private List<Mascota> mascotas;

    public Dueno(String nombre, String apellido, String email, int dni, int telefono) {
        super(nombre, apellido, email, dni, telefono);
        mascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascota mascota) {
        if (mascota != null && !this.mascotas.contains(mascota)) {
            mascotas.add(mascota);
            mascota.agregarObservador(this);
            System.out.println("DEBUG: Dueño " + this.getNombre() + " se ha suscrito a " + mascota.getNombre());
        }
    }

    public Mascota getMascota(String nombre) {
        return mascotas.stream()
                .filter(mascota -> mascota.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<Mascota> getMascotas() {
        return Collections.unmodifiableList(mascotas);
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("NOTIFICACIÓN para Dueño " + getNombre() + " " + getApellido() + ": " + mensaje);
    }
}
