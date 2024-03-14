import java.util.HashMap;
import java.util.Scanner;

public class AlteraDadosCliente {
    public static void main(String[] args) {
        HashMap<String, Object> client = CadastroCliente.registerClient();
        HashMap<String, Object> newClient = getClientToChangeData(client);
        if (newClient != null){
            System.out.println(newClient.get("Name"));
        }
    }
    public static HashMap<String, Object> getClientToChangeData(HashMap<String, Object> client){
        System.out.println("MENU - ALTERAÇÃO DE DADOS - CLEINTE : "+ client.get("Name"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite sua senha:");
        String passwd = sc.next();
        Object clientPasswd = client.get("passwd");

        if (!passwd.equals(clientPasswd)){
            return null;
        } else {
            while (true){
                changesMenu();
                int userInput = sc.nextInt();
                if (userInput == 1) {
                    System.out.println("Digite o novo nome: ");
                    String name = sc.next();
                    client.put("Name", name);
                } else if (userInput == 2) {
                    System.out.println("Digite a nova senha:");
                    String newPasswd = sc.next();
                    client.put("passwd", newPasswd);
                } else if (userInput == 3){
                    System.out.println("Operação cancelada.");
                    return client;
                } else {
                    System.out.println("Digite um valor do menu.");
                }
            }

        }
    }

    public static void changesMenu(){
        System.out.println("Escolha o que vai mudar:");
        System.out.println("1 - Nome.");
        System.out.println("2 - Senha.");
        System.out.println("3 - Cancelar.");
    }
}
