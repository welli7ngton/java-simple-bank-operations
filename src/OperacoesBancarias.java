import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;



public class OperacoesBancarias {
    private static HashMap<String, Object> loggedCustomer;
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<Integer, HashMap<String, Object>> allCustomers = Main.allBankUsers;
        loggedCustomer = Clientes.getCostumerById(1, allCustomers);

    }


    public static void deposit(){
        System.out.println("How much money do you want to deposit?");
        double value = sc.nextDouble();
        if (loggedCustomer != null){
            double oldAccountBalance = (double) loggedCustomer.get("AccountBalance");
            Object newAccountBalance = value + oldAccountBalance;
            loggedCustomer.put("AccountBalance", newAccountBalance);
            System.out.println("Operation Successful.");
        }
    }
    public static void withdraw(){
        System.out.println("How much money do you want to withdraw?");
        double value = sc.nextDouble();
        if (loggedCustomer != null && value <= (double) loggedCustomer.get("AccountBalance")){
            double oldAccountBalance = (double) loggedCustomer.get("AccountBalance");
            Object newAccountBalance = oldAccountBalance - value;
            loggedCustomer.put("AccountBalance", newAccountBalance);
            System.out.println("Operation Successful.");
        } else if (value > (double) loggedCustomer.get("AccountBalance")){
            System.out.println("Operation failed: Insufficient funds.");
        }
    }

    public static void transfer(){
        System.out.println("How much money do you want to transfer?");
        double transferenceMoney = sc.nextDouble();

        System.out.println("Type the Account Code of the account that you want to transfer:");
        int accountCode = sc.nextInt();

        System.out.print("Type your password to complete the operation: ");
        String passwd = sc.next();
        HashMap<String, Object> benefited = Main.allBankUsers.get(accountCode);
        if (validatePassword(passwd)) {
            if (benefited != null) {
                benefited.put("AccountBalance", ((double) benefited.get("AccountBalance") + transferenceMoney));
                loggedCustomer.put("AccountBalance", ((double) loggedCustomer.get("AccountBalance") - transferenceMoney));
                System.out.println("=====OPERATION RESULTS:=====");
                System.out.println("Benefited: " + benefited.get("Name"));
                System.out.println("Transference Value: " + transferenceMoney);
                System.out.println("Actual account balance: " + loggedCustomer.get("AccountBalance"));
                System.out.println("Operation Successful.");

            } else {
                System.out.println("Operation failed: Benefited does not exists.");
            }
        } else {
            System.out.println("Operation failed: Invalid Password.");
        }
    }

    public static boolean validatePassword(String passwd){
        return Objects.equals(passwd, (String) loggedCustomer.get("passwd"));
    }
}
