package ort.pr.dos.patrones.state.tamagochi;

public class Sediento extends Estado {

    private static final String NAME = "Sediento";

    @Override
    public Estado comer() {
        return new Sediento();
    }

    @Override
    public Estado beber() {
        return new Feliz();
    }

    @Override
    public Estado mimos() {
        return new Sediento();
    }

    @Override
    public String getNombre() {
        return NAME;
    }
}
