package co.edu.escuelaing.interactivebalckboardlife.entities;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class TicketMemory {
    private static final TicketMemory instance = new TicketMemory();
    private final List<String> ticketList;

    public TicketMemory(){
        ticketList = new CopyOnWriteArrayList<>();
    }

    public static TicketMemory getInstance(){
        return instance;
    }

    public synchronized String setTicketNumber(String ipAddress){
        Random r = new Random();
        int hash = r.hashCode();
        String ticketNumber = Integer.toString(hash);
        ticketList.add(ticketNumber);
        return ticketNumber;
    }


    public boolean checkTicket(String ticketNumber){
        return ticketList.remove(ticketNumber);
    }
}