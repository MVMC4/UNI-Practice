/*
 * App.java
 * ID: 202505647
 * Name: Mooketsi Magwaza Vincent
 */

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

     
        basicTasks();
        Menu menu = new Menu();
        menu.start();
        

    }

    static void studentTask() {

        ArrayList<Student> students = new ArrayList<>();
        
        Student student1 = new Student("0001", "Vince", "Computer Science", 3.5);
        Student student2 = new Student("0002", "Bella", "Mathematics", 3.6);
        
        students.add(student1);
        students.add(student2);

        for (Student student : students) {
            System.out.println(student);
        }

    }

    static void bankAccountTask() {

        BankAccount acc = new BankAccount("A001", "Naledi", 100);
        acc.deposit(50);
        boolean ok = acc.withdraw(25);

        System.out.println("Balance: " + acc.getBalance());
        System.out.println("Withdrawal successful: " + ok);
        System.out.println(acc);

    }

    static void basicTasks() {

        studentTask();
        bankAccountTask();

    }
    
}


class Menu {

    private BankAccount default_acc = new BankAccount("A001", "Naledi", 100);
    Scanner scanner = new Scanner(System.in);
    
    private void displayMenu() {

        System.out.println("\nMENU");
        showBar(30);

        System.out.println("\n1. Deposit ");
        System.out.println("2. Withdraw");
        System.out.println("3. Show Balance");
        System.out.println("4. Exit\n");
    }

    private void showBar(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("=");
        }
    }

    public void start() {
        boolean exit = false;
        while (!exit) {

            displayMenu();
            exit = handleUserInput();

        }
    }

    

    private boolean handleUserInput() {
        System.out.print(": ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            return handleUserChoice(choice);
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear the invalid input
            return false;
        }
    }


    private boolean handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                depositLogic();
                break;
            case 2:
                withdrawLogic();
                break;
            case 3:
                showBalanceLogic();
                break;
            case 4:
                System.out.println("Exiting...");
                return true;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
        }
        return false;
         
    }

    private void depositLogic() {

        System.out.print("Enter Deposit Amount: ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            default_acc.deposit(amount);
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); 
        }

    }

    private void withdrawLogic() {
        System.out.print("Enter Withdraw Amount: ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            default_acc.withdraw(amount);
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); 
        }

    }

    private void showBalanceLogic() {

        System.out.print("Current balance: " + default_acc.getBalance());

    }

}
