package dam.clases.gimnasio;

import dam.clases.gimnasio.internalConfig.Gimnasio;
import dam.clases.gimnasio.internalConfig.Taquilla;
import dam.clases.gimnasio.internalConfig.Trabajador;
import dam.clases.gimnasio.internalConfig.Usuario;

public class Main {
    public static void main(String[] args) {
        // Crear instancia de Gimnasio
        Gimnasio gimnasio = new Gimnasio();

        // Crear usuarios
        Usuario usuario1 = new Usuario("Usuario1", 123456789);
        Usuario usuario2 = new Usuario("Usuario2", 987654321);
        // Agregar taquillas a los usuarios
        Taquilla taquilla1 = new Taquilla(1);
        Taquilla taquilla2 = new Taquilla(2);
        Taquilla taquilla3 = new Taquilla(3);
        usuario1.asignarLlave(taquilla1);
        usuario1.asignarLlave(taquilla2);
        usuario2.asignarLlave(taquilla3);

        // Registrar usuarios en el gimnasio
        gimnasio.registrarUsuario(usuario1);
        gimnasio.registrarUsuario(usuario2);

        // Crear trabajadores
        Trabajador trabajador1 = new Trabajador("Admin", true, gimnasio);
        Trabajador trabajador2 = new Trabajador("Trabajador", false, gimnasio);

        // Registrar trabajadores en el gimnasio
        gimnasio.registrarTrabajador(trabajador1);
        gimnasio.registrarTrabajador(trabajador2);

        // Prueba de cierre global por trabajador con permisos
        System.out.println("Ejecutando cierre global por trabajador con permisos...");
        trabajador1.cierreGlobal();
        System.out.println("Cierre global realizado con éxito.");

        // Verificar que todas las taquillas están cerradas
        Taquilla[] taquillasUsuario1 = usuario1.getTaquillas();
        for (Taquilla taquilla : taquillasUsuario1) {
            if (taquilla != null && taquilla.taquillaDisponible()) {
                System.out.println("Error: La taquilla " + taquilla.getIdTaquilla() + " no está cerrada.");
            }
        }

        // Prueba de apertura global por trabajador con permisos
        System.out.println("Ejecutando apertura global por trabajador con permisos...");
        trabajador1.aperturaGlobal();
        System.out.println("Apertura global realizada con éxito.");

        // Verificar que todas las taquillas están abiertas
        for (Taquilla taquilla : taquillasUsuario1) {
            if (taquilla != null && !taquilla.taquillaDisponible()) {
                System.out.println("Error: La taquilla " + taquilla.getIdTaquilla() + " no está abierta.");
            }
        }

        // Prueba de eliminación de todas las taquillas por trabajador con permisos
        System.out.println("Ejecutando eliminación de todas las taquillas por trabajador con permisos...");
        trabajador1.eliminarTaquillaGlobal();
        System.out.println("Eliminación de todas las taquillas realizada con éxito.");

        // Verificar que todas las taquillas han sido eliminadas
        int count = 0;
        for (int i = 0; i < usuario1.getTaquillas().length; i++) {
            if (usuario1.getTaquillas()[i] == null) {
                count++;
            }
        }

        usuario1.asignarLlave(taquilla3);

        if (count == usuario1.getTaquillas().length) {
            System.out.println("Todas las taquillas del usuario 1 se han eliminado");
        }

        System.out.println("-----------------------------------");
;

        Usuario uas = new Usuario("Prueba", 1);
        Taquilla pruebataq = new Taquilla(33);

        uas.asignarLlave(pruebataq);
        gimnasio.registrarUsuario(uas);

        trabajador1.eliminarOneTaquilla(uas.getPulsera(), pruebataq.getIdTaquilla());
    }
}