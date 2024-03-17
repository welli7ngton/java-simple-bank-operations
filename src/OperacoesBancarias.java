import java.util.HashMap;
import java.util.Scanner;

public class OperacoesBancarias {
    private static HashMap<String, Object> loggedCustomer;
    private static HashMap<Integer, HashMap<String, Object>> allCustomers;

    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        allCustomers = Clientes.generateCustomers();
        loggedCustomer = Clientes.getCostumerById(1, allCustomers);
        deposit();
//        withdraw();
//        withdraw();
        transfer();
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

        if ((double) loggedCustomer.get("AccountBalance") >= transferenceMoney){
            HashMap<String, Object> benefited = allCustomers.get(accountCode);
            if (benefited != null){
                benefited.put("AccountBalance",((double)benefited.get("AccountBalance") + transferenceMoney));
                loggedCustomer.put("AccountBalance",((double) loggedCustomer.get("AccountBalance") - transferenceMoney));
                System.out.println("=====OPERATION RESULTS:=====");
                System.out.println("Benefited: " + benefited.get("Name"));
                System.out.println("Transference Value: " + transferenceMoney);
            } else {
                System.out.println("Operation failed: Benefited does not exists.");
            }
        } else {
            System.out.println("Operation failed: Insufficient funds.");
        }
    }
}
