package ort.pr.dos.tpfinal;

import ort.pr.dos.tpfinal.models.Doctor;
import ort.pr.dos.tpfinal.models.Dueno;
import ort.pr.dos.tpfinal.models.FichaMedica;
import ort.pr.dos.tpfinal.models.Mascota;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Veterinaria {
    private String nombre;
    private String ubicacion;
    private int telefono;
    private String email;
    private List<Doctor> doctores;
    private List<Dueno> duenos;
    private List<Mascota> mascotasInternadas;

    public Veterinaria(String nombre, String ubicacion, int telefono, String email) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.email = email;
        this.doctores = new ArrayList<>();
        this.duenos = new ArrayList<>();
        this.mascotasInternadas = new ArrayList<>();
    }

    public void agregarDoctor(Doctor doctor) {
        if (doctor != null && !this.doctores.contains(doctor)) {
            this.doctores.add(doctor);
            System.out.println("Doctor " + doctor.getNombre() + " agregado a la veterinaria.");
        } else if (doctor != null) {
            System.out.println("ADVERTENCIA: Doctor " + doctor.getNombre() + " ya está registrado en la veterinaria.");
        }
    }

    public void registrarDueno(Dueno dueno) {
        if (dueno != null && !this.duenos.contains(dueno)) {
            this.duenos.add(dueno);
            System.out.println("Dueno " + dueno.getNombre() + " registrado.");
        } else if (dueno != null) {
            System.out.println("ADVERTENCIA: Dueno " + dueno.getNombre() + " ya está registrado en la veterinaria.");
        }
    }

    public Dueno obtenerDueno(int dni) {
        return duenos.stream()
                .filter(dueno -> dueno.getDni() == dni)
                .findFirst()
                .orElse(null);
    }

    public Doctor obtenerDoctor(int dni) {
        return doctores.stream()
                .filter(doctor -> doctor.getDni() == dni)
                .findFirst()
                .orElse(null);
    }

    public void admitirMascota(Mascota mascota) {
        System.out.println("\n--- Proceso de Admisión para " + mascota.getNombre() + " ---");
        FichaMedica ficha = mascota.getFichaMedica();

        if (ficha == null) {
            String nuevoIdFicha = UUID.randomUUID().toString().substring(0, 8);
            mascota.setFichaMedica(new FichaMedica(nuevoIdFicha));
            ficha = mascota.getFichaMedica();
            System.out.println(mascota.getNombre() + " NO tenía ficha médica. Se creó una nueva con ID: " + ficha.getIdFicha());
        } else {
            System.out.println(mascota.getNombre() + " YA tenía ficha médica con ID: " + ficha.getIdFicha() + ". Se utilizará la existente.");
        }

        if (!this.mascotasInternadas.contains(mascota)) {
            this.mascotasInternadas.add(mascota);
        }
        System.out.println(mascota.getNombre() + " ha sido admitida con éxito en " + this.nombre + ".");
        System.out.println("-------------------------------------------\n");
    }

    public void darDeAltaMascota(Mascota mascota) {
        if (this.mascotasInternadas.remove(mascota)) {
            System.out.println("\n" + mascota.getNombre() + " ha sido dado/a de alta de " + this.nombre + ".");

            System.out.println("DEBUG: Desuscribiendo doctores de " + mascota.getNombre() + "...");
            for (Doctor doctor : this.doctores) {
                doctor.dejarDeSeguirMascota(mascota);
            }
            System.out.println("DEBUG: Proceso de desuscripción de doctores de " + mascota.getNombre() + " finalizado.");

        } else {
            System.out.println("\n" + mascota.getNombre() + " no se encuentra internado/a en " + this.nombre + ".");
        }
    }
}
