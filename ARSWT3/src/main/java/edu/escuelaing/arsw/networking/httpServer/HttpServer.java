package edu.escuelaing.arsw.networking.httpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private static HttpServer _instance = new HttpServer();

    private HttpServer(){

    }

    public static HttpServer getInstance(){
        return _instance;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean flag = true;
        String path = "";
        while(flag) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            //String path = "";
            int count = 0;
            while ((inputLine = in.readLine()) != null) {

                //System.out.println("Received: " + inputLine);
                count++;
                if (count <= 1) path = inputLine;
                if (!in.ready()) {
                    break;
                }
            }

            outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Title of the document</title>\n" + "</head>"
                    + "<body>"
                    + "My Web Site"
                    + "<img src=\"https://i0.wp.com/hipertextual.com/wp-content/uploads/2016/03/Clash-Royale.jpg\">"
                    + "</body>"
                    + "</html>" + inputLine;

            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {

            }
            out.close();

            in.close();

            clientSocket.close();
            //System.out.println(path);
        }
        //System.out.println(path);
        serverSocket.close();
    }
}
