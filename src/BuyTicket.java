import java.util.Scanner;

public class BuyTicket {

    int childPrice = 15;
    int studentPrice = 18;
    int adultPrice = 25;
    int pensionerPrice = 20;



    Scanner myScanner = new Scanner(System.in);
        static int childAmount = 0;
        static int studentAmount = 0;
        static int adultAmount = 0;
        static int pensionerAmount = 0;


        public void amountOfTickets(){
        System.out.println("Navigate with the numbers as presented.");
        System.out.println("1. Child ticket 15 kr.");
        System.out.println("2. Student ticket 18 kr.");
        System.out.println("3. Adult ticket 25 kr.");
        System.out.println("4. Pensioner ticket 20kr.");
        System.out.println("5. If done, exit.");
        boolean isRunning = true;
        while (isRunning)
            switch (myScanner.nextInt()) {
                case 1 -> childAmount++;
                case 2 -> studentAmount++;
                case 3 -> adultAmount++;
                case 4 -> pensionerAmount++;
                case 5 -> isRunning = false;
            }
    }


}
