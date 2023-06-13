package edu.escuelaing.arsw.taller2.app.Taller;

import javax.xml.crypto.Data;
import java.util.LinkedList;
import java.util.List;

public class GeneralMethods {

    public static double getMeanOfData(List<Double> data){
        Double total = 0.0;
        for (Double dato:data){
            total += dato;
        }
        total /= data.size();
        return Math.round(total*100.0)/100.0;
    }

    public static double getStandardDeviation(List<Double> data){
        Double standardDeviation = 0.0, squareRoot = 0.0, total = 0.0;
        Double mean = getMeanOfData(data);
        for (Double dato:data){
            standardDeviation += Math.pow((dato-mean),2);
        }
        squareRoot = standardDeviation / (data.size() -1) ;
        total = Math.sqrt(squareRoot);
        return Math.round(total*100.0)/100.0;
    }

}
