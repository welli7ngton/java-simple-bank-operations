import java.util.HashMap;

public class Clientes {

    public static void main(String[] args) {
        HashMap<Integer, HashMap<String, Object>>allCustomers = generateCustomers();
    }

    public static HashMap<String, Object> getCostumerById(int id, HashMap<Integer, HashMap<String, Object>>aC) {
        return aC.get(id);
    }

    public static HashMap<Integer, HashMap<String, Object>> generateCustomers(){
        HashMap<Integer, HashMap<String, Object>> allCostumers = new HashMap<>();
        HashMap<String, Object> clientOne = new HashMap<>();
        clientOne.put("Name", "Mariazinha");
        clientOne.put("AccountType", "Poupança");
        clientOne.put("passwd", "maria");
        clientOne.put("AccountBalance", 0.0);

        HashMap<String, Object> clientTwo = new HashMap<>();
        clientTwo.put("Name", "Joaozinho");
        clientTwo.put("AccountType", "Corrente");
        clientTwo.put("passwd", "joao");
        clientTwo.put("AccountBalance", 0.0);

        HashMap<String, Object> clientThree = new HashMap<>();
        clientThree.put("Name", "Pedrinho");
        clientThree.put("AccountType", "Corrente");
        clientThree.put("passwd", "pedro");
        clientThree.put("AccountBalance", 0.0);

        allCostumers.put(1, clientOne);
        allCostumers.put(2, clientTwo);
        allCostumers.put(3, clientThree);

        return allCostumers;
    }
}


