import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class CadastroCliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Object> clientTest = registerClient();
    }

    public static HashMap<String, Object> registerClient(){
        System.out.println("MENU - CADASTRO DE CLIENTE");
        System.out.print("Digite seu nome: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.print("Escolha o tipo de conta que quer criar: Corrente(1) Polpança(2): ");
        int userInput = sc.nextInt();

        String accountType = new String();
        if (userInput == 1){
            accountType = "Corrente";
        } else {
            accountType = "Polpança";
        }

        System.out.println("Digite a sua senha: ");
        String passwd = sc.next();

        double accountBalance = 0.0;

        HashMap<String, Object> registeredClient = new HashMap<>();
        registeredClient.put("Name", name);
        registeredClient.put("AccountType", accountType);
        registeredClient.put("passwd", passwd);
        registeredClient.put("AccountBalance", accountBalance);

        return registeredClient;
    }

    public static Object getClientName(HashMap<String, Object> client){
        return client.get("Name");
    }
    public static Object getClientAccountType(HashMap<String, Object> client){
        return client.get("AccountType");
    }
    public static Object getClientAccountBallance(HashMap<String, Object> client){
        return client.get("AccountBalance");
    }
}
