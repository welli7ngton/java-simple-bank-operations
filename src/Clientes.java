import java.util.HashMap;

public class Clientes {

    public static HashMap<String, Object> getCostumerById(int id, HashMap<Integer, HashMap<String, Object>>aC) {
        return aC.get(id);
    }

    public static HashMap<Integer, HashMap<String, Object>> generateCustomers(){
        HashMap<Integer, HashMap<String, Object>> allCostumers = new HashMap<>();
        HashMap<String, Object> clientOne = new HashMap<>();
        clientOne.put("Name", "Marilia");
        clientOne.put("AccountType", "Poupança");
        clientOne.put("passwd", "marilia");
        clientOne.put("AccountBalance", 0.0);

        HashMap<String, Object> clientTwo = new HashMap<>();
        clientTwo.put("Name", "Fernando");
        clientTwo.put("AccountType", "Corrente");
        clientTwo.put("passwd", "fernando");
        clientTwo.put("AccountBalance", 0.0);

        HashMap<String, Object> clientThree = new HashMap<>();
        clientThree.put("Name", "Mariana");
        clientThree.put("AccountType", "Corrente");
        clientThree.put("passwd", "mariana");
        clientThree.put("AccountBalance", 0.0);

        allCostumers.put(1, clientOne);
        allCostumers.put(2, clientTwo);
        allCostumers.put(3, clientThree);

        return allCostumers;
    }
}


