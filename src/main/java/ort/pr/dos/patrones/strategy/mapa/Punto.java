package ort.pr.dos.patrones.strategy.mapa;

public class Punto {
    private Long altitud;
    private Long longitud;
    private RecorridoStrategy strategy;

    public Punto(Long altitud, Long longitud, RecorridoStrategy strategy) {
        this.altitud = altitud;
        this.longitud = longitud;
        this.strategy = strategy;
    }

    public String obtenerRecorrido() {
        return this.strategy.obtenerRecorrido();
    }

    public Long getAltitud() {
        return altitud;
    }

    public void setAltitud(Long altitud) {
        this.altitud = altitud;
    }

    public Long getLongitud() {
        return longitud;
    }

    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    public RecorridoStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(RecorridoStrategy strategy) {
        this.strategy = strategy;
    }
}
