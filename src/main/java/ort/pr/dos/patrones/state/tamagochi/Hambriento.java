package ort.pr.dos.patrones.state.tamagochi;

public class Hambriento extends Estado {

    private static final String NAME = "Hambriento";

    @Override
    public Estado comer() {
        return new Feliz();
    }

    @Override
    public Estado beber() {
        return new Hambriento();
    }

    @Override
    public Estado mimos() {
        return new Hambriento();
    }

    @Override
    public String getNombre() {
        return NAME;
    }
}
