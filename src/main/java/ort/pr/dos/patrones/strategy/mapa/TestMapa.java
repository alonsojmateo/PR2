package ort.pr.dos.patrones.strategy.mapa;

public class TestMapa {
    public static void main(String[] args) {
        Punto punto = new Punto(10L, 20L, new AutoStrategy());
        System.out.println(punto.obtenerRecorrido());
    }
}
