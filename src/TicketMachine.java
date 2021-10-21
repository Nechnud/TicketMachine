import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TicketMachine {
    //Object so that the current time is printed in the ticket.
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Scanner minScanner = new Scanner(System.in);

        //myMonet set variable to 0 as this is how much money you have paid.
        int myMoney = 0;
        // Here we do not make a new object, so that we can keep all the value in the variables.
        public void purchase(StartYourJourney payment){

            //Making a new object for later.
            Menu mainMenu = new Menu();
            //payment.getSum allows me to get the value from the StartYourJourney. Here is also where Get method comes in.
            System.out.println("To pay: " + payment.getSum() + "kr.");
            System.out.println("Please continue with pay method");
            //myMoney += is so that nextInt in added to the value of 0.
            myMoney += minScanner.nextInt();
            /* If method to see if the customer has paid enough money for the ticket. And if successful take back to main menu.
            If the costumer does not have enough money the ticket will not be made.
             */
            if (myMoney >= payment.getSum()){
                System.out.println("Successful!");

                System.out.println("Going back to main menu");
                //Here is where the ticket printing method is called upon if the payment was successful. And also takes the user back to the main menu.
                ticketWriter(payment.getDepartureStation(), payment.getArrivalStation(), payment.getChildAmount(),payment.getStudentAmount(),
                        payment.getAdultAmount(), payment.getPensionerAmount(), payment.getSum());
                mainMenu.mainMenu();
            }
            else {
                System.out.println("Payment unsuccessful!");
                System.out.println("Please try again.");
                purchase(payment);

            }




        }
        /*Here is the BufferWriter that makes the ticket in to a txt document. The parameter allows me to keep the values
        that the customer has put in.
         */

        public void ticketWriter(String dep, String arrival,
                             int childA, int studentA, int adultA, int pensionerA, int totalPrice){

        Date date = new Date();
        try {
            BufferedWriter brTicket = new BufferedWriter(new FileWriter("Ticket.txt"));
            //Here is where date and time in being printed in the ticker alongside with variables with necessary info for the ticket.
            brTicket.write("Time of purchase " + formatter.format(date) +"\n" + "You are departing from " + dep + "\n" +
                    " Your destination is " + arrival);
            brTicket.write("\n" + " Child Ticket: " + childA + " \n " + "Student ticket: " + studentA + " \n " +
                    "Adult Ticket: " + adultA + " \n " + "Pensioner ticket: " + pensionerA + " \n " + "Total:  " + totalPrice )  ;
            brTicket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Here is where the ticket can be printed and shown to the customer. This method is also called in the main menu in case 3.
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
