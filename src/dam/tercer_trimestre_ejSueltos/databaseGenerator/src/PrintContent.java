package dam.tercer_trimestre_ejSueltos.databaseGenerator.src;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PrintContent {
    public PrintContent () {



        try {
            FileOutputStream f = new FileOutputStream("asd.txt");
            BufferedOutputStream bf = new BufferedOutputStream(f);
            OutputStreamWriter osw = new OutputStreamWriter(bf, "UFT-8");
            PrintWriter print = new PrintWriter(osw);

            print.println();
            print.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {

        }
    }
}
