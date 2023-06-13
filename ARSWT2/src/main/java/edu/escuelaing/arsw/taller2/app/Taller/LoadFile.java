package edu.escuelaing.arsw.taller2.app.Taller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LoadFile {

    /**
     * Metodo principal
     * @param args Path del archivo
     */
    public static void main(String[] args){
        File file = new File(args[0]);
        //File file = new File("src/main/resources/columna2.txt");
        LinkedList<Double> data = getDataFromFile(file);
        System.out.println(GeneralMethods.getMeanOfData(data));
        System.out.println(GeneralMethods.getStandardDeviation(data));
    }


    /**
     * Recibe el path de un archivo especifico y retorna una lista enlazada
     * con tipos de dato Double
     * @param file El path del archivo
     * @return La lista enlazada
     */
    public static LinkedList<Double> getDataFromFile(File file){
        LinkedList<Double> data = new LinkedList<Double>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            Double number;
            while ((line = bufferedReader.readLine()) != null){
                number = Double.valueOf(line);
                data.add(number);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return data;
    }


}
