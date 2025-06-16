package ort.pr.dos.patrones.state.tamagochi;

public abstract class Estado {

    public abstract Estado comer();
    public abstract Estado beber();
    public abstract Estado mimos();
    public abstract String getNombre();

    protected void beep(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.println("beep");
        }
    }


}
