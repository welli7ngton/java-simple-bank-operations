import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;



public class OperacoesBancarias {
    private static final Scanner sc = new Scanner(System.in);

    public static void deposit(){
        System.out.println("How much money do you want to deposit?");
        double value = sc.nextDouble();
        if (Main.loggedCustomer != null){
            double oldAccountBalance = (double) Main.loggedCustomer.get("AccountBalance");
            Object newAccountBalance = value + oldAccountBalance;
            Main.loggedCustomer.put("AccountBalance", newAccountBalance);
            System.out.println("Operation Successful.");
        }
    }
    public static void withdraw(){
        System.out.println("How much money do you want to withdraw?");
        double value = sc.nextDouble();
        if (Main.loggedCustomer != null && value <= (double) Main.loggedCustomer.get("AccountBalance")){
            double oldAccountBalance = (double) Main.loggedCustomer.get("AccountBalance");
            Object newAccountBalance = oldAccountBalance - value;
            Main.loggedCustomer.put("AccountBalance", newAccountBalance);
            System.out.println("Operation Successful.");
        } else if (value > (double) Main.loggedCustomer.get("AccountBalance")){
            System.out.println("Operation failed: Insufficient funds.");
        }
    }

    public static void transfer(){
        System.out.println("How much money do you want to transfer?");
        double transferenceMoney = sc.nextDouble();

        System.out.println("Type the 'Account Code' of the account that you want to transfer:");
        int accountCode = sc.nextInt();

        System.out.print("Type your password to complete the operation: ");
        String passwd = sc.next();
        HashMap<String, Object> benefited = Main.allBankUsers.get(accountCode);
        if (validatePassword(passwd)) {
            if (validateIfBenefitedExists(accountCode)) {
                if (validateIfActualCustomerHasEnoughMoney(transferenceMoney)) {
                    benefited.put("AccountBalance", ((double) benefited.get("AccountBalance") + transferenceMoney));
                    Main.loggedCustomer.put("AccountBalance", ((double) Main.loggedCustomer.get("AccountBalance") - transferenceMoney));
                    System.out.println("=====OPERATION RESULTS:=====");
                    System.out.println("Benefited: " + benefited.get("Name"));
                    System.out.println("Transference Value: " + transferenceMoney);
                    System.out.println("Actual account balance: " + Main.loggedCustomer.get("AccountBalance"));
                    System.out.println("Operation Successful.");
                } else {
                    System.out.println("Operation failed: Not enough money.");
                }

            } else {
                System.out.println("Operation failed: Benefited does not exists.");
            }
        } else {
            System.out.println("Operation failed: Invalid Password.");
        }
    }

    public static void showBankOperationsMenu(){
        System.out.println("BANK OPERATIONS - " + Main.loggedCustomer.get("Name"));
        System.out.println("Choose your operation: [1]Deposit [2]Withdraw [3]Transference [4]Cancel");
        int userInput = sc.nextInt();
        if (userInput == 1){
            deposit();
        } else if (userInput == 2){
            withdraw();
        } else if (userInput == 3) {
            transfer();
        } else {
            System.out.println("Program finished.");
        }
    }

    public static boolean validatePassword(String passwd){
        return Objects.equals(passwd, (String) Main.loggedCustomer.get("passwd"));
    }
    public static boolean validateIfBenefitedExists(int accountCode){
        return null != Main.allBankUsers.get(accountCode);
    }
    public static boolean validateIfActualCustomerHasEnoughMoney(double transferenceMoney){
        return (double) Main.loggedCustomer.get("AccountBalance") > transferenceMoney;
    }
}
