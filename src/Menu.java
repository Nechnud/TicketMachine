import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Menu {
    //Here is the one new object you will need in the main menu and a scanner.
    TicketMachine ticketMachine = new TicketMachine();
    Scanner myScanner = new Scanner(System.in);

    public void mainMenu()  {
        /*I did not make this object in to a new object since I want all the variables saved
        for this part of the menu.
        */
        StartYourJourney stationsAndDeparture;

        System.out.println("1. Start your journey!");
        System.out.println("2. Show all routes!");
        System.out.println("3. Show my tickets");
        System.out.println("4. Quit.");


        //I am using nextInt for the switch cases to navigate the menu,
        switch (myScanner.nextInt()){
            /*In case 1, I DO make a new object since a new ticket is being bought. When buying a new ticket,
            I want all the variables to be null, and as the customer is entering all the required info it will all be saved
            in the variables until the customer starts a new journey. I also call the method journeyStart. I will explain it in StartYourJourney class.
             */
            case 1:
                stationsAndDeparture = new StartYourJourney();
                stationsAndDeparture.journeyStart();

                mainMenu();


                break;
                /* In case 2, all I do is a BufferReader to print Departure document.

                 */
            case 2:
                System.out.println("Showing all routes");
                String line;

                try {
                    BufferedReader departure = new BufferedReader(new FileReader("Departure.txt"));
                    while ((line = departure.readLine()) != null) {
                        System.out.println(line);

                    }
                    departure.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


                mainMenu();

                break;
                /* In case 3, I call on the method printTicket from TicketMachine class. It will show you your prof of purchase.

                 */
            case 3:
                ticketMachine.printTicket();
                mainMenu();
                break;
                /* In case 4 there is a simple exit command with code 0 to show that it was intentional.

                 */
            case 4:
                System.out.println("Have a nice day, bye!");
                System.exit(0);
                break;


            case 5:


                break;



        }
    }
}
