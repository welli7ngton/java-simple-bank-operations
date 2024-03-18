import java.util.HashMap;
import java.util.Scanner;

public class CadastroCliente {
    private static final Scanner scCadastroClientes = new Scanner(System.in);

    public static int registerClient(){
        System.out.println("===REGISTER CUSTOMER===");
        System.out.print("Type your name: ");
        String name = scCadastroClientes.next();
        System.out.print("Choose your account type: Corrente(1) Polpança(2): ");
        int userInput = scCadastroClientes.nextInt();

        String accountType;
        if (userInput == 1){
            accountType = "Corrente";
        } else {
            accountType = "Polpança";
        }

        System.out.println("Create your password: ");
        String passwd = scCadastroClientes.next();

        double accountBalance = 0.0;

        HashMap<String, Object> newClient = new HashMap<>();
        newClient.put("Name", name);
        newClient.put("AccountType", accountType);
        newClient.put("passwd", passwd);
        newClient.put("AccountBalance", accountBalance);
        Main.allBankUsers.put(Main.allBankUsers.size()+1, newClient);
        System.out.println("Your 'Account Code is now: (" + Main.allBankUsers.size() + ") Keep this information safe." );
        return Main.allBankUsers.size();
    }

    public static Object getClientName(HashMap<String, Object> client){
        return client.get("Name");
    }
    public static Object getClientAccountType(HashMap<String, Object> client){
        return client.get("AccountType");
    }
    public static Object getClientAccountBalance(HashMap<String, Object> client){
        return client.get("AccountBalance");
    }
}
