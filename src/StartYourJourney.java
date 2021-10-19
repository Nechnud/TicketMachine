import java.io.*;
import java.util.Scanner;

public class StartYourJourney {

    String line;
   private String departureStation;
   private String arrivalStation;

    Scanner myScanner = new Scanner(System.in);
    static int childAmount = 0;
    static int studentAmount = 0;
    static int adultAmount = 0;
    static int pensionerAmount = 0;


    public void journeyStart() {
        int childPrice = 15;
        int studentPrice = 18;
        int adultPrice = 25;
        int pensionerPrice = 20;




        try {
            BufferedReader stations = new BufferedReader(new FileReader("Stations.txt"));
            while ((line = stations.readLine()) != null) {
                System.out.println(line);


            }
            stations.close();
            System.out.println("--------------------------------------------------------------");
            System.out.println("Choose your departure station");
            departureStation = myScanner.nextLine();

            System.out.println("You choose " + departureStation + "as your departure station.");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Choose your arrival station");
            arrivalStation = myScanner.nextLine();
            System.out.println("You choose " + arrivalStation + " as your arrival station.");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Taking you to checkout!");
            Thread.sleep(500);

            boolean isRunning = true;
            while (isRunning){
                System.out.println("Child tickets : " + childAmount +" price: " + (childAmount*childPrice));
                System.out.println("Student tickets : " + studentAmount + " price: " + (studentAmount*studentPrice));
                System.out.println("Adult tickets : " + adultAmount +  " price: " + (adultAmount*adultPrice));
                System.out.println("pensioner tickets : " + pensionerAmount + " price: " + (pensionerAmount*pensionerPrice));
                System.out.println("-----------------------------------------------");
                System.out.println("""
                    To add tickets please press :\s
                    '1' for child ticket
                    '2' for student ticket
                    '3' for adult ticket
                    '4' for pensioner ticket
                    Press '5' to continue to payment""");

                /*System.out.println("Navigate with the numbers as presented.");
                System.out.println("1. Child ticket 15 kr.");
                System.out.println("2. Student ticket 18 kr.");
                System.out.println("3. Adult ticket 25 kr.");
                System.out.println("4. Pensioner ticket 20kr.");
                System.out.println("5. If done, exit.");*/

                switch (myScanner.nextInt()) {
                    case 1 -> System.out.println( ++childAmount );
                    case 2 -> System.out.println( ++studentAmount );
                    case 3 -> System.out.println( ++adultAmount );
                    case 4 -> System.out.println( ++pensionerAmount );
                    case 5 -> isRunning = false;
                }


            }



        } catch (Exception e) {
            e.printStackTrace();
        }


        TicketMachine ticketMachine = new TicketMachine();

        ticketMachine.ticketWriter(departureStation, arrivalStation, childPrice, studentPrice, adultPrice, pensionerPrice,
                childAmount, studentAmount, adultAmount, pensionerAmount );
    }

        public void showAllDepartures () {
            try {
                BufferedReader departure = new BufferedReader(new FileReader("Departure.txt"));
                while ((line = departure.readLine()) != null) {
                    System.out.println(line);

                }
                departure.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }
}

