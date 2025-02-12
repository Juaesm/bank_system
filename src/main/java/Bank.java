import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class Bank {

    private Account account;
    private Scanner scanner;

    public Bank() {
        this.scanner = new Scanner(System.in);
        initializeBank();
    }

    private void initializeBank() {
        System.out.println("Welcome to the Bank");

        System.out.print("Add client name: ");
        String firstName = scanner.next();

        System.out.print("Add client last name: ");
        String lastName = scanner.next();

        System.out.print("Add client id: ");
        String clientId = scanner.next();

        this.account = new Account(new Client(firstName, lastName, clientId));

        System.out.println(account);
    }

    public void start() {
        int option = -1;
        while(option != 4) {
            displayMenu();
            option = scanner.nextInt();

            switch(option) {
                case 1:
                    addMoney();
                    break;
                case 2:
                    retrieveMoney();
                    break;
                case 3:
                    accountInfo();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Add Money");
        System.out.println("2. Retrieve Money");
        System.out.println("3. Account Info");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }

    private void addMoney() {
        System.out.print("Insert amount to add: ");
        if (scanner.hasNextDouble()) {
            double amountToAdd = scanner.nextDouble();
            double newBalance = account.addMoney(amountToAdd);
            if(newBalance == -1) {
                System.out.println("Invalid amount");
                return;
            }
            System.out.println("New balance: " + newBalance);
        } else {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        }
    }

    private void accountInfo() {
        System.out.println(account.toString());
    }

    private void retrieveMoney() {
        System.out.print("Insert amount to retrieve: ");
        if (scanner.hasNextDouble()) {
            double amountToRetrieve = scanner.nextDouble();
            double newBalance = account.retrieveMoney(amountToRetrieve);
            if(newBalance == -2) {
                System.out.println("Invalid amount");
                return;
            }
            System.out.println("New balance: " + newBalance);
        } else {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        }
    }
}