import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StationsChoice {
        String line;
        String travelTo;
        String departure;
        String allStations = null;
        Scanner myScanner = new Scanner(System.in);
        ArrayList<String> stationsList = new ArrayList<>();


        public void allRoutes() throws Exception{
            BufferedReader brAllRoutes = new BufferedReader( new FileReader("Departure.txt"));
            while ((line = brAllRoutes.readLine()) !=null){
                System.out.println(line);

            }
        }



        public void allStations() throws Exception{
            BufferedReader brAllStations = new BufferedReader( new FileReader("Stations.txt"));

            while ((allStations = brAllStations.readLine()) !=null){
                System.out.println(allStations);
                stationsList.add(allStations);
            }
            brAllStations.close();


    }
        public void stationDeparture(){
            departure = myScanner.nextLine();
            for (String stations : stationsList){
                if (departure.equalsIgnoreCase(stations)){
                    System.out.println("You choose departure station");
                    System.out.println(departure);
                }
            }
            stationTo();


        }

        public void stationTo(){
            System.out.println("What is your destination?");
            travelTo = myScanner.nextLine();
            for (String stations : stationsList){
                if(travelTo.equalsIgnoreCase(stations)){
                    System.out.println("You choose arrival station");
                    System.out.println(travelTo);
                }
            }

        }
}
