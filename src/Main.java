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
        while (true) {
            System.out.println("Choose one option: [1]Login [2]Register [3]Cancel");
            int userInput = scMain.nextInt();
            scMain.nextLine();

            if (userInput == 1 && !isLogged) {
                Login.login();
                isLogged = true;
            } else if (userInput == 2 && !isLogged) {
                loggedCustomerCode = CadastroCliente.registerClient();
                isLogged = true;
            } else if (userInput == 3) {
                isLogged = false;
                loggedCustomer = null;
                loggedCustomerCode = 0;
                System.out.println("Program closed.");
                break;
            }

            if (isLogged) {
                while (true) {
                    System.out.println("LOGGED AS - " + loggedCustomer.get("Name"));
                    System.out.println("Choose one option: [1]Change Register [2]Show Account info [3]Others Bank operations [4]Logout:");
                    int userInput2 = scMain.nextInt();
                    scMain.nextLine();
                    if (userInput2 == 1) {
                        AlteraDadosCliente.getClientToChangeData();
                    } else if (userInput2 == 2) {
                        CadastroCliente.showClientData();
                    } else if (userInput2 == 3) {
                        OperacoesBancarias.showBankOperationsMenu();
                    } else if (userInput2 == 4) {
                        loggedCustomer = null;
                        loggedCustomerCode = 0;
                        isLogged = false;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid option.");
                    }
                }
            }
        }
    }
}
