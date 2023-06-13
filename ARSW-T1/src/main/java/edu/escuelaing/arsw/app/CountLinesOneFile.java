package edu.escuelaing.arsw.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Primera version del taller donde se cuenta el numero de lineas de un archivo
 */
public class CountLinesOneFile {
    public static void main(String[] args) {
        String option = args[0];
        if (option.equals("phy")){
            System.out.println(countLinesPhysical(args[1]));
        }
        else if(option.equals("loc")){
            System.out.println(countLinesOfCode(args[1]));
        }
    }

    /**
     * Cuenta el numero de lineas totales del archivo
     * @param fileName el archivo a realizar el conteo
     * @return numero de lineas del archivo
     */
    public static long countLinesPhysical(String fileName) {
        long lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Cuenta el numero de lineas de codigo especificas del archivo
     * @param fileName el archivo a realizar el conteo
     * @return el numero de lineas de codigo del archivo
     */
    public static long countLinesOfCode(String fileName) {
        long lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String row;
            while ((row = reader.readLine()) != null) {
                if(getFirstCharacterFromString(row) != '*'
                    && getFirstCharacterFromString(row) != '/'
                && getFirstCharacterFromString(row) != ' ') lines++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

    /**
     * Metodo auxiliar que obtiene el primer caracter no vacio de una cadena
     * @param string la cadena a obtener primer caracter
     * @return el primer caracter
     */
    public static char getFirstCharacterFromString(String string){
        char value = ' ';
        try{
            int count = 0;
            while(string.charAt(count) == ' '){
                count++;
            }
            value = string.charAt(count);
        }
        catch (Exception e){ }
        return value;
    }
}