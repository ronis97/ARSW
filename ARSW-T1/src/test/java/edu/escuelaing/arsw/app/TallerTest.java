package edu.escuelaing.arsw.app;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class TallerTest
    extends TestCase
{
//    public void testPhyRecursive(){
//       String file = "/src/main/resources/carpeta";
//       assertTrue(CountLinesDirectory.calculateTotalLinesFromDirectory(new String[]{"phy",file}) == 12);
//    }

    public void testPhyOneFile(){
        assertTrue(CountLinesOneFile.countLinesPhysical("src/main/resources/English.java") == 45);
    }
    public void testLocOneFile(){
        assertTrue(CountLinesOneFile.countLinesOfCode("src/main/resources/English.java") == 27);
    }
}
