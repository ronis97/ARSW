package edu.escuelaing.arsw.app.HttpServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HttpServer {

    private static HttpServer _instance = new HttpServer();

    public HttpServer() {
    }

    public static HttpServer getInstance(){
        return _instance;
    }


    public static void start(String[] args) throws IOException {
        ExecutorService poolDeHilos = Executors.newFixedThreadPool(15);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        while(true) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            RequestProcesor requestProcesor = new RequestProcesor(clientSocket);
            poolDeHilos.execute(requestProcesor);
        }
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }




}