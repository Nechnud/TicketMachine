import java.util.Scanner;

public class BuyTicket {
    int childAmount;
    int studentAmount;
    int adultAmount;
    int pensionerAmount;

    int childPrice = 13;
    int studentPrice = 17;
    int adultPrice = 25;
    int pensionerPrice = 16;
    Menu backToMaineMenu = new Menu();
    StartYourJourney getDestinations = new StartYourJourney();
    Scanner myScanner = new Scanner(System.in);

    public void buyingTicketsMenu() throws InterruptedException {
        System.out.println("Your departure station: " + getDestinations.getDepartureStation());
        System.out.println("Your arrival station: " + getDestinations.getArrivalStation());
        System.out.println("Navigate the menu with numbers!");
        System.out.println("1. Child ticket ");
        System.out.println("2. Student ticket");
        System.out.println("3. Adult ticket");
        System.out.println("4. pensioner ticket");
        System.out.println("5 Back to main menu.");

        switch (myScanner.nextInt()) {
            case 1 -> {
                System.out.println(childAmount++);
                buyingTicketsMenu();
            }
            case 2 -> {
                System.out.println(studentAmount++);
                buyingTicketsMenu();
            }
            case 3 -> {
                System.out.println(adultAmount++);
                buyingTicketsMenu();
            }
            case 4 -> {
                System.out.println(pensionerAmount++);
                buyingTicketsMenu();
            }
            case 5 -> backToMaineMenu.mainMenu();
        }



    }
}
