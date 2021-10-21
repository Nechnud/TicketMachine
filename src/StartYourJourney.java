import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class StartYourJourney {
    /*TicketMachine is where you pay and print a ticket. I want the old one to be deleted and a new one is made */
    TicketMachine ticketMachine = new TicketMachine();
    Scanner myScanner = new Scanner(System.in);
    ArrayList<String> stationList = new ArrayList<>();

    // Some variables for later.
    String line;
    private String departureStation;
    private String arrivalStation;


     int childAmount = 0;
     int studentAmount = 0;
     int adultAmount = 0;
     int pensionerAmount = 0;
     int sum = 0;

    // This is the journeyStart that was used in the maine menu case 1. Where the purchasing of you journey begins.
    public void journeyStart() {
        // Price variables
        int childPrice = 15;
        int studentPrice = 18;
        int adultPrice = 25;
        int pensionerPrice = 20;


        try {
            /* BufferReader for the Stations document so that the costumer can see all the stations that can be chosen.
            The list is being printed and added in to arraylist so that the stations can be compared to what the customer chose.
             */

            BufferedReader stations = new BufferedReader(new FileReader("Stations.txt"));
            while ((line = stations.readLine()) != null) {
                System.out.println(line);
                stationList.add(line);


            }
            stations.close();
            System.out.println("--------------------------------------------------------------");
            System.out.println("Choose your departure station");
            /* Here the costumer is being asked to type in where they would like to depart from.
            Also checking if what the customer chose matches with the list.
             */
            departureStation = myScanner.nextLine();
            for (String locations : stationList) {
                if (departureStation.equalsIgnoreCase(locations)) {
                    System.out.println("You choose " + locations + "as your departure station.");
                    System.out.println("--------------------------------------------------------------");
                }



            }

            // Same thing as departure but with arrival instead.
            System.out.println("Choose your arrival station");
            arrivalStation = myScanner.nextLine();
            for (String locations : stationList) {
                if (arrivalStation.equalsIgnoreCase(locations)) {
                    System.out.println("You choose " + locations + "as your departure station.");
                    System.out.println("--------------------------------------------------------------");
                }

            }

            Thread.sleep(500);


            boolean isRunning = true;
            while (isRunning) {
                /* Here is where the amount of ticket the customer has put in and the cost for the tickets.
                I add the amount of child/student/adult/pensioner to be multiplied with the respective cost
                to get a total sum.
                 */
                sum = (childAmount * childPrice) + (studentAmount * studentPrice) + (adultAmount * adultPrice) + (pensionerAmount * pensionerPrice);
                System.out.println("Child tickets : " + childAmount + " price: " + (childAmount * childPrice));
                System.out.println("Student tickets : " + studentAmount + " price: " + (studentAmount * studentPrice));
                System.out.println("Adult tickets : " + adultAmount + " price: " + (adultAmount * adultPrice));
                System.out.println("pensioner tickets : " + pensionerAmount + " price: " + (pensionerAmount * pensionerPrice));
                System.out.println("Sum: " + sum);
                System.out.println("-----------------------------------------------");
                System.out.println("""
                        To add tickets please press :\s
                        '1' For child ticket.
                        '2' For student ticket.
                        '3' For adult ticket.
                        '4' For pensioner ticket.
                        Press '5' to continue to payment.""");


                switch (myScanner.nextInt()) {
                    /* In case 1-4 I had to put ++ before the variable so that +1 number is added before printing
                    otherwise it would print first and add after to make it a 0.
                    In case 5 I call ticketMachine.purchase(this); so that the processes is moved to payment and printing of ticket.
                    ticketMachine.purchase(this); is so that all the value is saved and moved to TicketMachine class -> purchase
                     */
                    case 1 -> System.out.println(++childAmount);
                    case 2 -> System.out.println(++studentAmount);
                    case 3 -> System.out.println(++adultAmount);
                    case 4 -> System.out.println(++pensionerAmount);
                    case 5 -> ticketMachine.purchase(this);
                }


            }
            // It's needed for Thread.sleep.
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Almost the same thing as ´this´ method.
        ticketMachine.ticketWriter(departureStation, arrivalStation, childAmount, studentAmount, adultAmount, pensionerAmount, sum);
    }


    // All get methods that are needed for later so that I can keep the value in the variables.
    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public int getChildAmount() {
        return childAmount;
    }

    public int getStudentAmount() {
        return studentAmount;
    }

    public int getAdultAmount() {
        return adultAmount;
    }

    public int getPensionerAmount() {
        return pensionerAmount;
    }

    public int getSum() {
        return sum;
    }
}