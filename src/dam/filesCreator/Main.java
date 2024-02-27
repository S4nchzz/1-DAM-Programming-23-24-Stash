package dam.filesCreator;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import dam.filesCreator.htmlCreator.*;
import dam.filesCreator.htmlCreator.content.*;

public class Main {
    public static void main(String[] args) {
        ElementoConContenido e = new ElementoConContenido("html");
        Documento d = new Documento(e);

        try {
            OutputStream f1 = new FileOutputStream("x.html");
            BufferedOutputStream f2 = new BufferedOutputStream(f1);
            OutputStreamWriter f3 = new OutputStreamWriter(f2, "UTF-8");
            PrintWriter f = new PrintWriter(f3);

            //Nuevo elemento que ira dentro de el elemento raiz
            ElementoConContenido e2 = new ElementoConContenido("p");

            //PCdata heredado de contenido
            Contenido c1 = new PCdata("Estoy dentro de p");

            ElementoConContenido r = new ElementoConContenido("h1");

            //Handler exception for duplicate attribute
            try {
                r.anadirAtributo("style", "background-color: #FF0;");
            } catch (Exception ex) {
                ex.getMessage();
            }

            Contenido c2 = new PCdata("estoy dentro de h1");

            e.anadirContenido(e2);
            e2.anadirContenido(c1);
            e2.anadirContenido(r);
            r.anadirContenido(c2);
            
            d.imprimir(f, 0);
            f.close();
            f3.close();
            f2.close();
            f1.close();

        } catch (FileNotFoundException fnf) {
            System.out.println("Sin archivo guaje");
        } catch (IOException ioe) {
            System.out.println("jodiose esto");
        }
    }
}

//Arreglar sangrado al escribir HTML

//Mapa nombre atributo valor attributo en elemento Map<String, String>