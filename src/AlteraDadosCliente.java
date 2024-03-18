import java.util.HashMap;
import java.util.Scanner;

public class AlteraDadosCliente {

    private static final Scanner scAlteraDados = new Scanner(System.in);

    public static void getClientToChangeData(){
        HashMap<String, Object> client = Main.allBankUsers.get(Main.loggedCustomerCode);
        System.out.println("MENU - ALTER DATA - CUSTOMER : "+ client.get("Name"));
        System.out.println("Type your password:");
        String passwd = scAlteraDados.next();
        Object clientPasswd = client.get("passwd");

        if (!passwd.equals(clientPasswd)){
            System.out.println("Operation failed: Invalid Password.");
        } else {
            while (true){
                changesMenu();
                int userInput = scAlteraDados.nextInt();
                if (userInput == 1) {
                    System.out.println("Type the new name: ");
                    String name = scAlteraDados.next();
                    client.put("Name", name);
                    System.out.println("New name added.");
                } else if (userInput == 2) {
                    System.out.println("Type the new password:");
                    String newPasswd = scAlteraDados.next();
                    client.put("passwd", newPasswd);
                } else if (userInput == 3){
                    System.out.println("Operation canceled.");
                    break;
                } else {
                    System.out.println("Type a menu value..");
                }
            }

        }
        scAlteraDados.close();
    }

    public static void changesMenu(){
        System.out.println("Choose yours changes:");
        System.out.println("1 - Name.");
        System.out.println("2 - Password.");
        System.out.println("3 - Cancel Operation.");
    }
}
