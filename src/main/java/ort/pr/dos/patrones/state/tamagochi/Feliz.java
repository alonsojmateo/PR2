package ort.pr.dos.patrones.state.tamagochi;

public class Feliz extends Estado {

    private static final String NAME = "Feliz";

    @Override
    public Estado comer() {
        return new Feliz();
    }

    @Override
    public Estado beber() {
        super.beep(5);
        return new Feliz();
    }

    @Override
    public Estado mimos() {
        return new Feliz();
    }

    @Override
    public String getNombre() {
        return NAME;
    }



}
