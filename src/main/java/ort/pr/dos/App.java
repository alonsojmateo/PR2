package ort.pr.dos;

import ort.pr.dos.tpfinal.Veterinaria;
import ort.pr.dos.tpfinal.models.*;
import ort.pr.dos.tpfinal.models.enums.AccionDoctor;
import ort.pr.dos.tpfinal.models.enums.TipoMascota;
import ort.pr.dos.tpfinal.state.*;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("--- INICIANDO SISTEMA DE VETERINARIA CON OBSERVER ---");

        // 1. Instanciar la Veterinaria
        Veterinaria miVeterinaria = new Veterinaria("Veterinaria SaludAnimal", "CABA", 11223344, "vet@mail.com");

        // 2. Crear Dueños y Doctores
        System.out.println("\n--- Creando Dueños y Doctores ---");
        Dueno duenoAna = new Dueno("Ana", "Perez", "ana.perez@email.com", 12345678, 1122334455);
        Dueno duenoLuis = new Dueno("Luis", "Gomez", "luis.gomez@email.com", 87654321, 1199887766);

        Doctor docMartinez = new Doctor("Juan", "Martinez", "juan.m@email.com", 11223344, 1155443322, TipoMascota.PERRO);
        Doctor docLaura = new Doctor("Laura", "Diaz", "laura.d@email.com", 55667788, 1112345678, TipoMascota.GATO);

        // 3. Registrar Dueños y Doctores en la Veterinaria
        miVeterinaria.registrarDueno(duenoAna);
        miVeterinaria.registrarDueno(duenoLuis);
        miVeterinaria.agregarDoctor(docMartinez);
        miVeterinaria.agregarDoctor(docLaura);

        // 4. Crear Mascotas y asignarlas a Dueños
        System.out.println("\n--- Creando Mascotas y Asignándolas a Dueños ---");
        // Nota: Al agregar la mascota al dueño, el dueño se convierte en observador.
        Mascota firulais = new Mascota("Firulais", 10.5, true, TipoMascota.PERRO, new EstadoMascotaFeliz());
        duenoAna.agregarMascota(firulais); // Ana se suscribe a Firulais

        Mascota michi = new Mascota("Michi", 3.0, false, TipoMascota.GATO, new EstadoMascotaFeliz());
        duenoLuis.agregarMascota(michi); // Luis se suscribe a Michi

        Mascota sol = new Mascota("Sol", 25.0, true, TipoMascota.PERRO, new EstadoMascotaFeliz());
        duenoAna.agregarMascota(sol); // Ana se suscribe a Sol

        System.out.println("Mascotas de Ana: " + duenoAna.getMascotas().size());
        System.out.println("Mascotas de Luis: " + duenoLuis.getMascotas().size());


        // 5. Escenario 1: Mascota ingresa por primera vez (Firulais)
        System.out.println("\n\n--- ESCENARIO 1: FIRULAIS INGRESA POR PRIMERA VEZ (Doctor Martinez lo examina y lo sigue) ---");
        miVeterinaria.admitirMascota(firulais);

        // Doctor Martinez examina a Firulais
        // Peso actual (8.7 kg), vacuna actualizada (true), y lo encuentra enfermo
        // Al examinar, docMartinez se convierte en observador de Firulais.
        docMartinez.examinarMascota(firulais, 8.7, true, new EstadoMascotaEnfermo());
        // Firulais está ahora en estado Enfermo.
        // Esperar: NOTIFICACIÓN para Dueño Ana (cambio de Feliz a Enfermo)
        // Esperar: NOTIFICACIÓN para Doctor Juan Martinez (cambio de Feliz a Enfermo)


        // Simular que el doctor le da medicina a Firulais (está enfermo)
        System.out.println("\n--- Doctor Martinez medica a Firulais ---");
        docMartinez.realizarAccion(firulais, AccionDoctor.MEDICAR);
        // Firulais debería cambiar a EstadoMascotaFeliz.
        // Esperar: NOTIFICACIÓN para Dueño Ana (cambio de Enfermo a Feliz)
        // Esperar: NOTIFICACIÓN para Doctor Juan Martinez (cambio de Enfermo a Feliz)


        // Verificar el historial clínico de Firulais
        System.out.println("\n--- Historial Clínico de Firulais ---");
        if (firulais.getFichaMedica() != null) {
            firulais.getFichaMedica().imprimirHistorialCompleto();
        } else {
            System.out.println("Firulais aún no tiene ficha médica.");
        }
        System.out.println("Peso actual de Firulais (según Mascota.getPeso()): " + firulais.getPeso() + " kg.");


        // 6. Escenario 2: Mascota ya existente (Michi) para un control de rutina
        System.out.println("\n\n--- ESCENARIO 2: MICHI INGRESA PARA CONTROL (Doctor Laura lo examina y lo sigue) ---");
        // Para simular que Michi ya tiene historial previo, le agregamos un registro manual.
        if (michi.getFichaMedica() == null) {
            michi.setFichaMedica(new FichaMedica("FICHA-MICHI-PREVIO"));
        }
        michi.getFichaMedica().agregarRegistro(new RegistroVisita(
                LocalDate.of(2024, 1, 10),
                "Control anual previo",
                "Vacuna Antirrábica",
                "Peso en esa fecha: 4.0 kg."
        ));

        // Asignamos un estado inicial a Michi antes de su nueva visita (Hambriento)
        // Esto debería generar una notificación para Luis (su dueño)
        System.out.println("\n--- Michi se pone hambriento antes de la visita ---");
        michi.setEstado(new EstadoMascotaHambriento());
        // Esperar: NOTIFICACIÓN para Dueño Luis (cambio de Feliz a Hambriento)


        System.out.println("\nMichi entra a la veterinaria hambriento.");
        miVeterinaria.admitirMascota(michi);

        // Doctora Laura examina a Michi. Al examinar, docLaura se convierte en observadora.
        docLaura.examinarMascota(michi, 4.3, true, new EstadoMascotaHambriento());
        // Michi sigue en EstadoMascotaHambriento después del examen (no debería haber notificación aquí si el estado no cambió).
        // Esperar: NOTIFICACIÓN para Doctor Laura (cambio de Hambriento a Hambriento) - (si el estado cambió a la misma instancia).
        //          Si es la misma instancia de estado, no debería notificar por la condición `this.estado != estadoAnterior`.

        // Doctora Laura le da de comer a Michi
        System.out.println("\n--- Doctora Laura alimenta a Michi ---");
        docLaura.realizarAccion(michi, AccionDoctor.ALIMENTAR); // Usamos ALIMENTAR
        // Michi debería cambiar a EstadoMascotaFeliz.
        // Esperar: NOTIFICACIÓN para Dueño Luis (cambio de Hambriento a Feliz)
        // Esperar: NOTIFICACIÓN para Doctor Laura (cambio de Hambriento a Feliz)

        // Verificar el historial clínico de Michi
        System.out.println("\n--- Historial Clínico de Michi ---");
        if (michi.getFichaMedica() != null) {
            michi.getFichaMedica().imprimirHistorialCompleto();
        } else {
            System.out.println("Michi aún no tiene ficha médica.");
        }
        System.out.println("Peso actual de Michi (según Mascota.getPeso()): " + michi.getPeso() + " kg.");


        // 7. Simular una Mascota Sedienta (Sol)
        System.out.println("\n\n--- ESCENARIO 3: SOL ENTRA SEDIENTA (Doc Martinez ya la sigue por ser de Ana) ---");
        miVeterinaria.admitirMascota(sol);

        // Establecemos el estado de Sol a Sediento (simulando que llega así)
        System.out.println("\n--- Sol se pone sedienta antes del examen ---");
        sol.setEstado(new EstadoMascotaSediento());
        // Esperar: NOTIFICACIÓN para Dueño Ana (cambio de Feliz a Sediento)
        // Nota: docMartinez NO es observador de Sol aún, a menos que la examine o la siga explícitamente.
        //          Vamos a hacer que docMartinez la siga manualmente para ver la notificación.
        docMartinez.seguirMascota(sol);
        System.out.println("DEBUG: Doctor Martinez comienza a seguir a Sol.");

        docMartinez.examinarMascota(sol, 25.1, true, new EstadoMascotaSediento());
        // Sol está Sedienta (estado no debería cambiar si ya lo estaba)
        // No debería haber notificación si ya estaba en ese estado.

        // Doctor Martinez le da de tomar a Sol
        System.out.println("\n--- Doctor Martinez hidrata a Sol ---");
        docMartinez.realizarAccion(sol, AccionDoctor.HIDRATAR); // Usamos HIDRATAR
        // Sol debería cambiar a EstadoMascotaFeliz
        // Esperar: NOTIFICACIÓN para Dueño Ana (cambio de Sediento a Feliz)
        // Esperar: NOTIFICACIÓN para Doctor Juan Martinez (cambio de Sediento a Feliz)

        // Verificar historial de Sol
        System.out.println("\n--- Historial Clínico de Sol ---");
        if (sol.getFichaMedica() != null) {
            sol.getFichaMedica().imprimirHistorialCompleto();
        } else {
            System.out.println("Sol aún no tiene ficha médica.");
        }
        System.out.println("Peso actual de Sol (según Mascota.getPeso()): " + sol.getPeso() + " kg.");


        // 8. Dar de alta una mascota y dejar de seguirla
        System.out.println("\n\n--- Dar de Alta Mascota y Eliminar Observadores ---");
        miVeterinaria.darDeAltaMascota(firulais);

        // Intentar dar de alta una mascota que no está internada
        miVeterinaria.darDeAltaMascota(new Mascota("NoExistente", 0, false, TipoMascota.GATO, new EstadoMascotaFeliz()));

        // Intenta realizar una acción sobre Firulais (aunque dado de alta),
        // no debería haber notificaciones del observer si ya fueron eliminados.
        System.out.println("\n--- Intentando medicar a Firulais (observadores removidos) ---");
        docMartinez.realizarAccion(firulais, AccionDoctor.MEDICAR);


        System.out.println("\n--- FIN DEL PROGRAMA ---");
    }

}
