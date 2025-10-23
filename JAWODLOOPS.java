import java.util.Scanner;

public class TicketSystem {
    public static void main(String[] args) {
        final double BASE_PRICE = 200.0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter customer age (or type 'exit' to quit): ");
            String ageInput = sc.nextLine();

            if (ageInput.equalsIgnoreCase("exit")) {
                System.out.println("Program ended.");
                break;
            }

            int age;
            try {
                age = Integer.parseInt(ageInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid age.");
                continue;
            }

            System.out.print("Enter the day of the week: ");
            String day = sc.nextLine().trim();
            day = day.substring(0,1).toUpperCase() + day.substring(1).toLowerCase();

            System.out.print("Enter number of tickets: ");
            int numTickets;
            try {
                numTickets = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for tickets.");
                continue;
            }

            double pricePerTicket;
            String discountType = "";

          
            if (age < 7) {
                pricePerTicket = 0;
                discountType = "Child below 7 (Free ticket)";
            } else if (age >= 60) {
                double seniorPrice = BASE_PRICE * 0.8;  
                if (day.equals("Wednesday")) {
                    double wedPrice = BASE_PRICE * 0.5; 
                    
                    if (wedPrice < seniorPrice) {
                        pricePerTicket = wedPrice;
                        discountType = "Wednesday 50% discount";
                    } else {
                        pricePerTicket = seniorPrice;
                        discountType = "Senior 20% discount";
                    }
                } else {
                    pricePerTicket = seniorPrice;
                    discountType = "Senior 20% discount";
                }
            } else if (day.equals("Wednesday")) {
                pricePerTicket = BASE_PRICE * 0.5;
                discountType = "Wednesday 50% discount";
            } else {
                pricePerTicket = BASE_PRICE;
                discountType = "No discount";
            }

            double totalPrice = pricePerTicket * numTickets;

            
            if (totalPrice > 1000) {
                totalPrice *= 0.9;
                discountType += " + Extra 10% discount (total > 1000)";
            }

           
            System.out.println("\n--- Ticket Summary ---");
            System.out.printf("Tickets: %d x $%.2f\n", numTickets, pricePerTicket);
            System.out.println("Discount applied: " + discountType);

            if (totalPrice < 200) {
                System.out.println("Final Amount: $0.00 (Minimum purchase not reached)");
                System.out.println("Message: Minimum purchase not reached");
            } else {
                System.out.printf("Final Amount to Pay: $%.2f\n", totalPrice);
            }
            System.out.println("----------------------");
        }
while (true) { 
 
    String ageInput = sc.nextLine();

    if (ageInput.equalsIgnoreCase("exit")) {  
        System.out.println("Program ended.");
        break;  
    }

    
}
        sc.close();
    }
}