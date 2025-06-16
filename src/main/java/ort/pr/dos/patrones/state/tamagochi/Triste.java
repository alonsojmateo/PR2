package ort.pr.dos.patrones.state.tamagochi;

public class Triste extends Estado {

    private static final String NAME = "Triste";

    @Override
    public Estado comer() {
        super.beep(2);
        System.out.println("Vomitando");
        return new Triste();
    }

    @Override
    public Estado beber() {
        super.beep(3);
        System.out.println("Titilando");
        return new Triste();
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
