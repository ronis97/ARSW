package edu.escuelaing.arsw.tallerspring;

public class Singleton {

    private static Singleton singletonInstance;

    public static Singleton getInstance(){
        return singletonInstance;
    }

    private Singleton(){
        singletonInstance = new Singleton();
    }

    public int getNumber(){
        return 0;
    }
}
