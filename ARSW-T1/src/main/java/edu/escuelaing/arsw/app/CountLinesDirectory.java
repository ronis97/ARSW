package edu.escuelaing.arsw.app;

import java.io.File;


/**
 * Segunda version del programa donde se hace uso de la clase FirstVersion
 */

public class CountLinesDirectory {
    public static void main(String[] args) {
        //calculateTotalLinesFromDirectory(args);
        String file = "/src/main/resources/carpeta";
        System.out.println(calculateTotalLinesFromDirectory(new String[]{"phy",file}));
    }

    /**
     *
     * @param params lista de parametros donde incluye el tipo de conteo, si es phy es el numero total
     *               de filas y si es loc es solo contar el numero de lineas de codigo
     * @return el numero de lineas del directorio
     */
    public static long calculateTotalLinesFromDirectory(String[] params){
        String option = params[0];
        File file = new File(params[1]);
        long lines = 0;
        if (file.isDirectory()){
            for(File file1: file.listFiles()){
                System.out.println(CountLinesOneFile.countLinesPhysical(file1.getName()));
            }
        }
        System.out.println(lines);
        return lines;
    }

}
