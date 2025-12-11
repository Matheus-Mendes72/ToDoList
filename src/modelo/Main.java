package modelo;

public class Main {
	public static void main(String[] args) {
		
	}

}

//import java.util.*;
//
//public class Agency {
//
//    private Map<Integer, Account> accounts = new HashMap<>();
//    private Map<String, Client> clients = new HashMap<>();
//    private int nextAccountId = 0;
//
//    private Account getAccount(int accId) {
//        if (!accounts.containsKey(accId))
//            throw new RuntimeException("fail: conta nao encontrada");
//        return accounts.get(accId);
//    }
//
//    public void addClient(String clientId) {
//        if (clients.containsKey(clientId))
//            return;
//
//        Client c = new Client(clientId);
//        clients.put(clientId, c);
//
//        Account cc = new CheckingAccount(nextAccountId++, clientId);
//        Account cp = new SavingsAccount(nextAccountId++, clientId);
//
//        accounts.put(cc.getId(), cc);
//        accounts.put(cp.getId(), cp);
//
//        c.addAccount(cc);
//        c.addAccount(cp);
//    }
//
//    public void deposit(int accId, double value) {
//        getAccount(accId).deposit(value);
//    }
//
//    public void withdraw(int accId, double value) {
//        getAccount(accId).withdraw(value);
//    }
//
//    public void transfer(int from, int to, double value) {
//        Account a = getAccount(from);
//        Account b = getAccount(to);
//        a.transfer(b, value);
//    }
//
//    public void updateMonthly() {
//        for (Account acc : accounts.values())
//            acc.updateMonthly();
//    }
//
//    public void show() {
//        System.out.println("- Clients");
//        for (Client c : clients.values())
//            System.out.println(c);
//
//        System.out.println("- Accounts");
//        for (Account acc : accounts.values())
//            System.out.println(acc);
//    }
//}
