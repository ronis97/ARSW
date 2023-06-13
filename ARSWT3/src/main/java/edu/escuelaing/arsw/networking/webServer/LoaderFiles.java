package edu.escuelaing.arsw.networking.webServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LoaderFiles {

    public static String LoadFile(File file){
        String fileLoaded = "";
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()){
                String line = myReader.nextLine();
                fileLoaded += line;
            }
            myReader.close();
        }
         catch (Exception e) {
            e.printStackTrace();
        }
        return fileLoaded;
    }
}
