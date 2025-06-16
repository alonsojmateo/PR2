package ort.pr.dos.tpfinal.models;

import java.time.LocalDate;

public class RegistroVisita {
    private LocalDate fecha;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;

    public RegistroVisita(LocalDate fecha, String diagnostico, String tratamiento, String observaciones) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    @Override
    public String toString() {
        return "  - Fecha: " + fecha +
                "\n    Diagnóstico: " + diagnostico +
                "\n    Tratamiento: " + tratamiento +
                "\n    Observaciones: " + observaciones;
    }
}
