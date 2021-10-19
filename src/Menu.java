import java.util.Scanner;

public class Menu {
    StartYourJourney stationsAndDeparture = new StartYourJourney();
    TicketMachine ticketMachine = new TicketMachine();

    Scanner myScanner = new Scanner(System.in);

    public void mainMenu() throws InterruptedException {
        System.out.println("1. Start your journey!");
        System.out.println("2. Show all routes!");
        System.out.println("3. Show my tickets");
        System.out.println("4. Quit.");



        switch (myScanner.nextInt()){
            case 1:
                stationsAndDeparture.journeyStart();

                mainMenu();


                break;
            case 2:
                System.out.println("Showing all routes");
                Thread.sleep(550);
                System.out.println("----------------------------------------------");
                stationsAndDeparture.showAllDepartures();
                System.out.println("----------------------------------------------");
                mainMenu();

                break;
            case 3:
                ticketMachine.printTicket();
                mainMenu();
                break;

            case 4:
                System.out.println("Have a nice day, bye!");
                break;


            case 5:


                break;




        }
    }
}
