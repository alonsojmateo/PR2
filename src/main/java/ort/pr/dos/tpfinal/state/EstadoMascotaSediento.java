package ort.pr.dos.tpfinal.state;

public class EstadoMascotaSediento implements EstadoMascota {

    @Override
    public EstadoMascota darComer() {
        System.out.println("La mascota sedienta comió, pero sigue teniendo sed.");
        return new EstadoMascotaSediento();
    }

    @Override
    public EstadoMascota darMedicina() {
        System.out.println("La mascota sedienta recibió medicina, pero sigue teniendo sed.");
        return new EstadoMascotaSediento();
    }

    @Override
    public EstadoMascota darTomar() {
        System.out.println("La mascota sedienta bebió agua y ahora está feliz.");
        return new EstadoMascotaFeliz();
    }
}