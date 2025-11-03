import java.util.Scanner;

public class CinemaTicketSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double basePrice = 200.0;

        System.out.println("=======================================");
        System.out.println("         CINEMA TICKETING SYSTEM");
        System.out.println("=======================================");
        System.out.println("Submitted by: JAWOD");
        System.out.println("Course & Section: BSIT 1B");
        System.out.println("=======================================\n");

        while (true) {
            System.out.print("Enter age of customer (or type 'exit' to quit): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("\nThank you for using the Cinema Ticketing System!");
                System.out.println("=======================================");
                break;
            }

            int age = Integer.parseInt(input);

            System.out.print("Enter day of the week: ");
            String day = sc.nextLine();

            System.out.print("Enter number of tickets: ");
            int tickets = Integer.parseInt(sc.nextLine());

            double pricePerTicket = basePrice;
            String discountApplied = "None";

            if (age < 7) {
                pricePerTicket = 0;
                discountApplied = "Free (Under 7 years old)";
            } else if (day.equalsIgnoreCase("Wednesday")) {
                pricePerTicket = basePrice * 0.5;
                discountApplied = "50% Wednesday Discount";
            } else if (age >= 60) {
                pricePerTicket = basePrice * 0.8;
                discountApplied = "20% Senior Discount";
            }

            double total = pricePerTicket * tickets;
            double extraDiscount = 0;

            if (total > 1000) {
                extraDiscount = total * 0.10;
                total -= extraDiscount;
            }

            if (total < 200) {
                System.out.println("\nMinimum purchase not reached.");
            }

            System.out.println("\n---------------------------------------");
            System.out.println("              TICKET SUMMARY");
            System.out.println("---------------------------------------");
            System.out.println("Tickets: " + tickets + " x ₱" + String.format("%.2f", pricePerTicket));
            System.out.println("Discount Applied: " + discountApplied);
            if (extraDiscount > 0) {
                System.out.println("Extra 10% Discount: ₱" + String.format("%.2f", extraDiscount));
            }
            System.out.println("Final Amount to Pay: ₱" + String.format("%.2f", total));
            System.out.println("---------------------------------------\n");
        }

        sc.close();
    }
}       