package ort.pr.dos.tpfinal.models;

import ort.pr.dos.tpfinal.models.enums.AccionDoctor;
import ort.pr.dos.tpfinal.models.enums.TipoMascota;
import ort.pr.dos.tpfinal.observer.Observer;
import ort.pr.dos.tpfinal.state.EstadoMascota;

import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private String nombre;
    private double peso;
    private Boolean tieneVacuna;
    private TipoMascota tipo;
    private EstadoMascota estado;
    private FichaMedica fichaMedica;

    private List<Observer> observadores;

    public Mascota(String nombre, double peso, Boolean tieneVacuna, TipoMascota tipo, EstadoMascota estado) {
        this.nombre = nombre;
        this.peso = peso;
        this.tieneVacuna = tieneVacuna;
        this.tipo = tipo;
        this.estado = estado;
        this.fichaMedica = null;
        this.observadores = new ArrayList<>();
    }

    public void accionar(AccionDoctor accion) {
        if (this.estado == null) {
            System.out.println(this.getNombre() + " no tiene un estado definido para responder a la acción " + accion);
            return;
        }
        System.out.println(this.getNombre() + " (Estado: " + this.estado.getClass().getSimpleName() + ") responde a la acción: " + accion);

        EstadoMascota estadoAnterior = this.estado;

        switch (accion) {
            case ALIMENTAR:
                this.estado = this.estado.darComer();
                break;
            case HIDRATAR:
                this.estado = this.estado.darTomar();
                break;
            case MEDICAR:
                this.estado = this.estado.darMedicina();
                break;
            default:
                System.out.println(this.getNombre() + " no sabe cómo responder a esta acción.");
                break;
        }

        if (this.estado != estadoAnterior) {
            String mensaje = "¡Estado de " + this.nombre + " ha cambiado de " +
                    estadoAnterior.getClass().getSimpleName() +
                    " a " + this.estado.getClass().getSimpleName() + "!";
            notificarObservadores(mensaje);
        }
    }

    public void agregarObservador(Observer o) {
        if (o != null && !observadores.contains(o)) {
            observadores.add(o);
            System.out.println("DEBUG: " + o.getClass().getSimpleName() + " añadido como observador de " + this.nombre);
        }
    }

    public void eliminarObservador(Observer o) {
        if (o != null) {
            observadores.remove(o);
            System.out.println("DEBUG: " + o.getClass().getSimpleName() + " eliminado como observador de " + this.nombre);
        }
    }

    private void notificarObservadores(String mensaje) {
        System.out.println("Notificando a " + observadores.size() + " observadores de " + this.nombre + "...");
        for (Observer o : observadores) {
            o.notificar(this.nombre + ": " + mensaje);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public Boolean getTieneVacuna() {
        return tieneVacuna;
    }

    public TipoMascota getTipo() {
        return tipo;
    }

    public EstadoMascota getEstado() {
        return estado;
    }

    public FichaMedica getFichaMedica() {
        return fichaMedica;
    }

    public void setFichaMedica(FichaMedica fichaMedica) {
        this.fichaMedica = fichaMedica;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTieneVacuna(Boolean tieneVacuna) {
        this.tieneVacuna = tieneVacuna;
    }

    public void setTipo(TipoMascota tipo) {
        this.tipo = tipo;
    }

    public void setEstado(EstadoMascota estado) {
        this.estado = estado;
    }
}
