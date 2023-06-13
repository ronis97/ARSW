package edu.escuelaing.arsw.networking.webServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = serverCreation();
        //ExecutorService threadpool = Executors.newFixedThreadPool(10);
        boolean flag = true;
        while (flag) {
            Socket clientSocket = clientCreation(serverSocket);

            // Desarrollo
            //threadpool.execute(ThreadExecuter.main());
            loadPage(clientSocket);

        }
        serverSocket.close();
    }

    public static void loadPage(Socket clientSocket) throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        String outputLine = "", path = "";
        int count = 0;
        while ((inputLine = in.readLine()) != null) {
            //System.out.println("Receive: " + inputLine);
            if (!in.ready()) break;
            count++;
            if (count <= 1) path = inputLine;
        }
        System.out.println(path);

        try {
            if (!path.isEmpty()) outputLine += checkPath(path.split(" ")[1]);
        }
        catch (Exception e){
            outputLine = "";
            outputLine += "HTTP/1.1 404 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    //+ "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Title of the document</title>\n" + "</head>"
                    + "<body>"
                    + "ERROR 404"
                    + "</body>"
                    + "</html>"
                    + "\r\n";
            System.out.println(outputLine);
        }
        out.println(outputLine);

        out.close();
        in.close();
        clientSocket.close();
    }

    public static String checkPath(String path) throws IOException {
        String outputLine = "";
        System.out.println(path);

        if (path.contains("css")) {
            //System.out.println("css aca");
            outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/css\r\n"
                    + "\r\n";
            String info = "";
            info = new String(Files.readAllBytes(Paths.get("resources/" + path)), StandardCharsets.UTF_8);
            //System.out.println(info);
            outputLine += info;
        }
            else if(path.contains("js")){
            outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/js\r\n"
                    + "\r\n";
            String info = "";
            info = new String(Files.readAllBytes(Paths.get("resources/" + path)), StandardCharsets.UTF_8);
            //System.out.println(info);
            outputLine += info;
        } else if (path.contains("html")) {
            //System.out.println("html aca");
            outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    //                   + "Content-Type: text/css\r\n"
                    + "\r\n";
            outputLine += LoaderFiles.LoadFile(new File("resources/index.html"));
        }
        else{
            outputLine = "";
            outputLine += "HTTP/1.1 404 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    //+ "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Title of the document</title>\n" + "</head>"
                    + "<body>"
                    + "ERROR 404"
                    + "</body>"
                    + "</html>"
                    + "\r\n";
        }
        return outputLine;
    }

    public static ServerSocket serverCreation(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        }catch (IOException e){
            System.err.println("No pudo escuchar en puerto: 35000.");
            System.exit(1);
        }
        return serverSocket;
    }

    public static Socket clientCreation(ServerSocket serverSocket){
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        return clientSocket;
    }



    private static int getPort(){
        if (System.getenv("PORT") != null) return Integer.parseInt(System.getenv("PORT"));
        return 35000;
    }

}
