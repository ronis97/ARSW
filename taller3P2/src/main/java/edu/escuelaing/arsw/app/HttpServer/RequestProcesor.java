package edu.escuelaing.arsw.app.HttpServer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

public class RequestProcesor implements Runnable{

    private final Socket clientSocket;
    private String outputLine;
    private PrintWriter out;

    public RequestProcesor(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            process();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void process() throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine, component = null;
        while ((inputLine = in.readLine()) != null) {
            if(inputLine.matches("(GET)+.*")){
                component = inputLine.split(" ")[1];
            }
            if (!in.ready()) {
                break;
            }
        }
        String extension=null;
        if(component.matches(".*(.html)") || component.matches(".*(.css)") || component.matches(".*(.js)")) {
            if(component.matches(".*(.html)")){
                extension="html";
            }else if(component.matches(".*(.css)")){
                extension="css";
            }else if(component.matches(".*(.js)")){
                extension="js";
            }
            StringBuffer stringBuffer = new StringBuffer();
            System.out.println(component);
            try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+component))) {
                String nameFile = null;
                stringBuffer.append("HTTP/1.1 200 OK\r\n");
                stringBuffer.append("Content-Type: text/"+ extension+"\r\n");
                stringBuffer.append("\r\n");
                while ((nameFile = reader.readLine()) != null) {
                    stringBuffer.append(nameFile);
                }
            }catch (Exception e){
                stringBuffer = error(stringBuffer);
                System.out.println(e);
            }
            out.println();
            out.println(stringBuffer.toString());
        }else if(component.matches(".*(.jpg)") || component.matches(".*(.png)")){
           imagen(component);
        }

        out.close();
        in.close();
    }


    /**
     * Carga la imagen
     * @param component
     */
    public void imagen(String component) throws IOException{
        String extension=null;
        if(component.matches(".*(.jpg)") || component.matches(".*(.png)")){
            if(component.matches(".*(.jpg)")){
                extension="jpg";
            }if(component.matches(".*(.png)")){
                extension="png";
            }
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: image/"+extension);
            out.println();
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+component));
            ImageIO.write(image, "PNG", clientSocket.getOutputStream());
        }

    }

    /**
     * Si no se encuentra el recurso se genera el mensaje
     * @param stringBuffer
     * @return
     */
    public StringBuffer error(StringBuffer stringBuffer){
        outputLine = "HTTP/1.1 404 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title of the document</title>\n" + "</head>"
                + "<body>"
                + "No se encontro el recurso"
                + "</body>"
                + "</html>" ;
        stringBuffer =  new StringBuffer();
        stringBuffer.append(outputLine);
        return stringBuffer;

    }



}
