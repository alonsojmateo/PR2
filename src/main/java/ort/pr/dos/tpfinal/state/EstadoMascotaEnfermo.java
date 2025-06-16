package ort.pr.dos.tpfinal.state;

public class EstadoMascotaEnfermo implements EstadoMascota {

    @Override
    public EstadoMascota darComer() {
        System.out.println("La mascota enferma intenta comer, pero sigue sintiéndose mal.");
        return new EstadoMascotaEnfermo(); // Permanece en estado enfermo
    }

    @Override
    public EstadoMascota darMedicina() {
        System.out.println("La mascota recibió medicina y se recuperó. ¡Ahora está feliz!");
        return new EstadoMascotaFeliz(); // Transiciona a feliz
    }

    @Override
    public EstadoMascota darTomar() {
        System.out.println("La mascota enferma bebe agua, pero su estado de salud general no cambia.");
        return new EstadoMascotaEnfermo(); // Permanece en estado enfermo
    }
}