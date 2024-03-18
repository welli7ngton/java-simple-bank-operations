import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static HashMap<Integer, HashMap<String, Object>> allBankUsers = Clientes.generateCustomers();

    public static HashMap<String, Object> loggedCustomer;
    public static int loggedCustomerCode;
    public static boolean isLogged = false;
    private static final Scanner scMain = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Choose one option: [1]Login [2]Register [3]Cancel");
        int userInput = scMain.nextInt();

        if (userInput == 1 && !isLogged){
            login();
            isLogged = true;
        } else if (userInput == 2 && !isLogged){
            loggedCustomerCode = CadastroCliente.registerClient();
            isLogged = true;
        } else if (userInput == 3){
            System.out.println("Program closed.");
        }

        if (isLogged){
            System.out.println("LOGGED AS - " + loggedCustomer.get("Name"));
            System.out.println("Choose one option: [1]Change Register [2]Others Bank operations:");
            userInput = scMain.nextInt();
            if (userInput == 1){
                AlteraDadosCliente.getClientToChangeData();
            }
        }

    }

    public static void login(){
        System.out.println("=====LOGIN=====");
        System.out.println("Type your 'Account Code':");
        int accountCode = scMain.nextInt();
        if (accountCode <= allBankUsers.size()){
            HashMap<String, Object> customer = allBankUsers.get(accountCode);
            System.out.println("Type you password:");
            String passwd = scMain.next();
            if (Objects.equals(passwd, (String) customer.get("passwd"))){
                System.out.println("Login Successful.");
                loggedCustomerCode = accountCode;
                isLogged = true;
                loggedCustomer = customer;
            } else {
                System.out.println("Login Failed: wrong password.");
            }
        } else {
            System.out.println("Login Failed 404: Account Code not found.");
        }
    }
}