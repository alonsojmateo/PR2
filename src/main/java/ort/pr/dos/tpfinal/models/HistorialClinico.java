package ort.pr.dos.tpfinal.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistorialClinico {
    private List<RegistroVisita> registros;

    public HistorialClinico() {
        this.registros = new ArrayList<>();
    }

    public void agregarRegistro(RegistroVisita registro) {
        if (registro != null) {
            this.registros.add(registro);
            System.out.println(">>> Registro agregado al historial.");
        } else {
            System.out.println("ERROR: No se puede agregar un registro nulo al historial.");
        }
    }

    public List<RegistroVisita> getRegistros() {
        return Collections.unmodifiableList(registros);
    }

    public void imprimirHistorial() {
        if (registros.isEmpty()) {
            System.out.println("  El historial clínico está vacío.");
            return;
        }
        System.out.println("  --- Registros del Historial Clínico ---");
        for (int i = 0; i < registros.size(); i++) {
            System.out.println("  Registro #" + (i + 1) + ":");
            System.out.println(registros.get(i));
            if (i < registros.size() - 1) {
                System.out.println("  --------------------------------------");
            }
        }
        System.out.println("  --------------------------------------");
    }
}
