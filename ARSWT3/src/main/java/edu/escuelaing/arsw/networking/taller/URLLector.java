package edu.escuelaing.arsw.networking.taller;

import java.net.MalformedURLException;
import java.net.URL;

public class URLLector {


    public static  void main(String[] args){
        try {
            URL myURL = new URL("https://campusvirtual.escuelaing.edu.co/moodle/course/view.php?id=2660#hello");
            System.out.println("Protocol: " + myURL.getProtocol());
            System.out.println("Authority: "+ myURL.getAuthority());
            System.out.println("Host: "+ myURL.getHost());
            System.out.println("Port: " +myURL.getPort());
            System.out.println("Path: " +myURL.getPath());
            System.out.println("Query: " +myURL.getQuery());
            System.out.println("File: " +myURL.getFile());
            System.out.println("Ref: " +myURL.getRef());

        } catch (MalformedURLException e){
            e.printStackTrace();
        }

    }
}
