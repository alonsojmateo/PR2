package ort.pr.dos.tpfinal.models;

import ort.pr.dos.tpfinal.models.enums.AccionDoctor;
import ort.pr.dos.tpfinal.models.enums.TipoMascota;
import ort.pr.dos.tpfinal.observer.Observer;
import ort.pr.dos.tpfinal.state.EstadoMascota;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Persona implements Observer {

    private TipoMascota especialidad;
    private List<Mascota> mascotasSeguidas;

    public Doctor(String nombre, String apellido, String email, int dni, int telefono, TipoMascota especialidad) {
        super(nombre, apellido, email, dni, telefono);
        this.especialidad = especialidad;
        this.mascotasSeguidas = new ArrayList<>();
    }

    public void examinarMascota(Mascota mascota, double pesoObservado, Boolean tieneVacunaObservado, EstadoMascota estadoInicialDetectado) {
        System.out.println("\n--- Doctor " + getNombre() + " examinando a " + mascota.getNombre() + " ---");

        mascota.agregarObservador(this);

        mascota.setPeso(pesoObservado);
        mascota.setTieneVacuna(tieneVacunaObservado);
        mascota.setEstado(estadoInicialDetectado);
        System.out.println("Datos actuales de " + mascota.getNombre() + " actualizados: Peso=" + pesoObservado + "kg, Vacuna=" + tieneVacunaObservado);

        FichaMedica ficha = mascota.getFichaMedica();
        if (ficha == null) {
            System.err.println("ERROR: " + mascota.getNombre() + " no tiene ficha médica. No se puede registrar la observación.");
            return;
        }

        String diagnosticoObs = "Examen inicial y observación.";
        String tratamientoObs = "Ninguno inicialmente.";
        String observacionesAdicionales = "Peso observado: " + pesoObservado + "kg. Vacuna status: " + tieneVacunaObservado + ".";

        RegistroVisita registro = new RegistroVisita(LocalDate.now(), diagnosticoObs, tratamientoObs, observacionesAdicionales);
        ficha.agregarRegistro(registro);
        System.out.println("Registro de observación inicial añadido a la ficha de " + mascota.getNombre() + ".");

        mascota.setEstado(estadoInicialDetectado);
        System.out.println("Estado inicial de " + mascota.getNombre() + " establecido a: " + mascota.getEstado().getClass().getSimpleName() + ".");
        System.out.println("-------------------------------------------\n");
    }

    public void realizarAccion(Mascota mascota, AccionDoctor accionDoctor) {
        if (this.especialidad != mascota.getTipo()) {
            System.out.println("ADVERTENCIA: Doctor " + getNombre() + " (Especialidad: " + especialidad +
                    ") no tiene la especialidad para realizar la acción en " + mascota.getNombre() + " (Tipo: " + mascota.getTipo() + ").");
            return;
        }

        System.out.println("\nDoctor " + getNombre() + " realiza la acción " + accionDoctor + " sobre " + mascota.getNombre());
        mascota.accionar(accionDoctor);
    }

    public void seguirMascota(Mascota mascota) {
        if (mascota != null) {
            mascota.agregarObservador(this);
            this.mascotasSeguidas.add(mascota);
        }
    }

    public void dejarDeSeguirMascota(Mascota mascota) {
        if (mascota != null) {
            mascota.eliminarObservador(this);
        }
    }


    @Override
    public void notificar(String mensaje) { // <-- MÉTODO REQUERIDO POR Observer
        System.out.println("NOTIFICACIÓN para Doctor " + getNombre() + " " + getApellido() + " (Especialidad: " + especialidad + "): " + mensaje);
    }
}