package ort.pr.dos.tpfinal.state;

public class EstadoMascotaFeliz implements EstadoMascota {

    @Override
    public EstadoMascota darComer() {
        System.out.println("La mascota ya está feliz y saciada. No necesita comer.");
        return this;
    }

    @Override
    public EstadoMascota darMedicina() {
        System.out.println("La mascota feliz recibió medicina. ¡Se ha puesto enferma!");
        return new EstadoMascotaEnfermo();
    }

    @Override
    public EstadoMascota darTomar() {
        System.out.println("La mascota ya está feliz e hidratada. No necesita beber.");
        return this;
    }
}