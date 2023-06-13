package edu.escuelaing.arsw.taller2.app.Generics;

import java.util.*;

public class GenericTutorial {

    public static void main(String args[]){
        List initList = new LinkedList();
        initList = new LinkedList();
        initList.add(0);
        Integer x = (Integer) initList.iterator().next();

//        List<String> ls = new ArrayList<Object>();
//        List<Object> lo = ls;
        printCollection(initList);
    }

    public static void printCollection(Collection c){
        Iterator i = c.iterator();
        for(int k = 0; k < c.size(); k++){
            System.out.println(i.next());
        }
    }

    public static void printCollection1(Collection<?> c){
        for(Object e: c){
            System.out.println(e);
        }
    }
     public static void fromArrayToCollection(Object[] a, Collection<?> c) {
        for (Object o : a) {
         //   c.add(o); // compile-time error
        }
    }
    static <T> void fromArrayToCollection1(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o); // Correct
        }
    }
}
