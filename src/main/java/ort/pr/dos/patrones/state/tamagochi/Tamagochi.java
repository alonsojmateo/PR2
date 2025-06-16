package ort.pr.dos.patrones.state.tamagochi;


public class Tamagochi {
    String name;
    Estado estado;

    public Tamagochi(String name, Estado estado) {
        this.name = name;
        this.estado = estado;
    }

    public void comer() {
        this.estado = this.estado.comer();
    }

    public void beber() {
        this.estado = this.estado.beber();
    }

    public void mimos() {
        this.estado = this.estado.mimos();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tamagochi => ");
        sb.append("name: '").append(name).append('\'');
        sb.append(", estado: ").append(estado.getNombre());
        return sb.toString();
    }
}
