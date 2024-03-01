package dam.filesCreator;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import dam.filesCreator.htmlCreator.fileType.*;

public class Main {
    public static void main(String[] args) {

        try {
            OutputStream f1 = new FileOutputStream("x.html");
            BufferedOutputStream f2 = new BufferedOutputStream(f1);
            OutputStreamWriter f3 = new OutputStreamWriter(f2, "UTF-8");
            PrintWriter f = new PrintWriter(f3);

            DocumentoHTML d = new DocumentoHTML("Bomba de cobalto");
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