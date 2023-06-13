package edu.escuelaing.arsw.taller2.app;

import edu.escuelaing.arsw.taller2.app.Taller.GeneralMethods;
import edu.escuelaing.arsw.taller2.app.Taller.LinkedList;
import edu.escuelaing.arsw.taller2.app.Taller.LoadFile;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class LoadFileTests
    extends TestCase
{
    public void testColumn1(){
        File file = new File("src/main/resources/columna1.txt");
        LinkedList<Double> data1 = LoadFile.getDataFromFile(file);
        assertTrue(GeneralMethods.getMeanOfData(data1) == 550.60);
        assertTrue(GeneralMethods.getStandardDeviation(data1) == 572.03);
    }

    public void testColumn2(){
        File file = new File("src/main/resources/columna2.txt");
        LinkedList<Double> data1 = LoadFile.getDataFromFile(file);
        assertTrue(GeneralMethods.getMeanOfData(data1) == 60.32);
        assertTrue(GeneralMethods.getStandardDeviation(data1) == 62.26);
    }
}
