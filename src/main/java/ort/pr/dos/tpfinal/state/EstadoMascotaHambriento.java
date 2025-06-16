package ort.pr.dos.tpfinal.state;

public class EstadoMascotaHambriento implements EstadoMascota {

    @Override
    public EstadoMascota darComer() {
        System.out.println("La mascota hambrienta comió y ahora está feliz.");
        return new EstadoMascotaFeliz();
    }

    @Override
    public EstadoMascota darMedicina() {
        System.out.println("La mascota hambrienta recibió medicina, pero sigue teniendo hambre.");
        return new EstadoMascotaHambriento();
    }

    @Override
    public EstadoMascota darTomar() {
        System.out.println("La mascota hambrienta bebió, pero sigue teniendo hambre.");
        return new EstadoMascotaHambriento();
    }
}