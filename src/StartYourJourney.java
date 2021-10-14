import java.io.*;
import java.util.Scanner;

public class StartYourJourney {

    String line;
    String departureStation;
    String arrivalStation;


    Scanner myScanner = new Scanner(System.in);


    public void journeyStart() {
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



        } catch (Exception e) {
            e.printStackTrace();
        }
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

