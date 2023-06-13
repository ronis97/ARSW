package edu.escuelaing.arsw.networking.httpServer;

import java.io.IOException;

public class HttpServerController {
    public static void main(String[] args){
        prueba pr = prueba.getInstance();
        try{
            pr.start(args);
        }catch (IOException o){
            throw new RuntimeException(o);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
