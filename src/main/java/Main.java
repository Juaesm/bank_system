import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank");

        System.out.print("Add client name: ");
        String firstName = scanner.next();

        System.out.print("Add client last name: ");
        String lastName = scanner.next();

        System.out.print("Add client id: ");
        String clientId = scanner.next();

        Account account = new Account(new Client(firstName, lastName, clientId));
        Bank bank = new Bank(account);

        System.out.println(bank.getAccount().toString());

        int option = -1;
        while(option != 3) {
            displayMenu();
            option = scanner.nextInt();

            switch(option) {
                case 1:
                    addMoney(bank, scanner);
                    break;
                case 2:
                    retrieveMoney(bank, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Add Money");
        System.out.println("2. Retrieve Money");
        System.out.println("3. Exit");
        System.out.print("Select an option: ");
    }

    public static void addMoney(Bank bank, Scanner scanner) {
        System.out.print("Insert amount to add: ");
        if (scanner.hasNextDouble()) {
            double amountToAdd = scanner.nextDouble();
            double newBalance = bank.getAccount().addMoney(amountToAdd);
            if(newBalance == -1)
            {
                System.out.println("Invalid amount");
                return;
            }
            System.out.println("New balance: " + newBalance);
        } else {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next(); // Clear invalid input
        }
    }

    public static void retrieveMoney(Bank bank, Scanner scanner) {
        System.out.print("Insert amount to retrieve: ");
        if (scanner.hasNextDouble()) {
            double amountToRetrieve = scanner.nextDouble();
            double newBalance = bank.getAccount().retrieveMoney(amountToRetrieve);
            if(newBalance == -2)
            {
                System.out.println("Invalid amount");
                return;
            }
            System.out.println("New balance: " + newBalance);
        } else {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next(); // Clear invalid input
        }
    }
}