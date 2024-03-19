import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    private static final Scanner scLogin = new Scanner(System.in);
    public static void login(){
        System.out.println("=====LOGIN=====");
        System.out.println("Type your 'Account Code':");
        int accountCode = scLogin.nextInt();
        if (accountCode <= Main.allBankUsers.size()){
            HashMap<String, Object> customer = Main.allBankUsers.get(accountCode);
            System.out.println("Type you password:");
            String passwd = scLogin.next();
            if (Objects.equals(passwd, (String) customer.get("passwd"))){
                System.out.println("Login Successful.");
                Main.loggedCustomerCode = accountCode;
                Main.isLogged = true;
                Main.loggedCustomer = customer;
            } else {
                System.out.println("Login Failed: wrong password.");
            }
        } else {
            System.out.println("Login Failed 404: Account Code not found.");
        }
    }
}
