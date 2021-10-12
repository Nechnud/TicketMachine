import java.util.Scanner;
public class Menu {

    StationsChoice stations = new StationsChoice();
    Scanner myScanner = new Scanner(System.in);

    public void mainMenu(){
        System.out.println("");
        System.out.println("1. Show all routes.");
        System.out.println("2. Search journey.");
        System.out.println("3. My tickets.");
        System.out.println("4. Buy tickets. ");
        System.out.println("");

        try {
            switch (myScanner.nextInt()) {
                case 1:
                    stations.allRoutes();
                    mainMenu();
                    break;

                case 2:
                    System.out.println("Where would you like to travel from/to?");
                    stations.allStations();
                    stations.stationDeparture();


                    break;


                case 3:

                    break;
            }

        } catch (Exception e){
            e.printStackTrace();
            mainMenu();
        }
    }

}
