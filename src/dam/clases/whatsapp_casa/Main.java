package dam.clases.whatsapp_casa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Persona admin = new Persona();

        admin.setNombre("IyanAdmin");
        admin.setTelfID("33");
        
        Grupo gr = new Grupo(admin);
        Persona pr1 = new Persona();

        pr1.setNombre("Iyan1");
        pr1.setTelfID("0");
        gr.addPersona(pr1);

        Persona pr2 = new Persona();
        pr2.setNombre("Iyan2");
        pr2.setTelfID("1");
        gr.addPersona(pr2);

        Persona pr3 = new Persona();
        pr3.setNombre("Iyan3");
        pr3.setTelfID("2");
        gr.addPersona(pr3);

        System.out.println(Arrays.toString(gr.miembros()));

        gr.deletePersona("0");
        gr.deletePersona("1");

        gr.setEstado("2", true);
        System.out.println(gr.buscar("0"));

        if (gr.buscar("1") != -1) {
            System.out.println("El usuario se encuentra en el sistema");
        } else {
            System.out.println("El usuario no se encuentra en el sistema");
        }

        System.out.println(gr.pertenece("2"));
        System.out.println(gr);
    }
}