import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketMachine {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public void ticketWriter(String dep, String arrival, int childP, int studentP, int adultP, int pensionerP,
                             int childA, int studentA, int adultA, int pensionerA){

        Date date = new Date();
        try {
            BufferedWriter brTicket = new BufferedWriter(new FileWriter("Ticket.txt"));
            brTicket.write("Time of purchase " + formatter.format(date) +"\n" + "You are departing from " + dep + "\n" +
                    " Your destination is " + arrival);

            brTicket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printTicket(){
        String line;
        try {
            BufferedReader brPrintTicket = new BufferedReader(new FileReader("Ticket.txt"));
            while ((line = brPrintTicket.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
