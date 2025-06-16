package ort.pr.dos.tpfinal.models;

public class FichaMedica {
    private String idFicha;
    private HistorialClinico historial;

    public FichaMedica(String idFicha) {
        if (idFicha == null || idFicha.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la ficha médica no puede ser nulo o vacío.");
        }
        this.idFicha = idFicha;
        this.historial = new HistorialClinico(); // Se crea un nuevo historial junto con la ficha
    }

    public String getIdFicha() {
        return idFicha;
    }

    public HistorialClinico getHistorial() {
        return historial;
    }

    public void agregarRegistro(RegistroVisita registro) {
        if (historial != null) {
            historial.agregarRegistro(registro);
        } else {
            System.out.println("ERROR: La ficha médica no tiene un historial clínico asociado.");
        }
    }

    public void imprimirHistorialCompleto() {
        System.out.println("\n--- Ficha Médica ID: " + idFicha + " ---");
        historial.imprimirHistorial();
        System.out.println("--- Fin Ficha Médica ID: " + idFicha + " ---\n");
    }
}
