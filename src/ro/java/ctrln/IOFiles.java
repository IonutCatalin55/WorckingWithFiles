package ro.java.ctrln;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOFiles {

    public static void main(String[] args) {
       // FileInputStream fileInputStream = null; varianta originala unde intitializat cu null
       // FileOutputStream fileOutputStream = null;

        try(FileInputStream fileInputStream = new FileInputStream("data.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("output" + System.currentTimeMillis() +".txt")) { //varianta refactorizata try with resources//inchide resursele
            //fileInputStream = new FileInputStream("data.txt");
            //fileOutputStream = new FileOutputStream("output.txt");

            int read = fileInputStream.read();
            while (read != -1) { // [ -1 ] = iseamna finalul fisierului //se citeste ATATA TIMP CAT NU AM AJUNS LA FINALUL FISIERULUI
                fileOutputStream.write(read);
                read = fileInputStream.read(); // FUNCTIONEAZA CA INCREMENTARE READ++
            }
            System.out.println("Citire si scriere completa!");

        } catch (FileNotFoundException fnfe) {
            System.out.println("Fisierul nu a fost gasit");
        } catch (IOException ioe) {
            System.out.println("IOException a aparut!");
        }

    }
}
