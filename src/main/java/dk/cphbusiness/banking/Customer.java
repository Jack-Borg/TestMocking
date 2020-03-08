package dk.cphbusiness.banking;

import java.util.ArrayList;
import java.util.List;

public class Customer implements ICustomer {
    String cpr;
    String name;
    IBank bank;
    List<IAccount> accounts;

    public Customer(IBank bank, String cpr, String name) {
        this.bank = bank;
        this.cpr = cpr;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void transfer(long amount, IAccount sourceAccount, ICustomer target, IAccount targetAccount) {

    }

    public IBank getBank() {
        return bank;
    }

    public String getCpr() {
        return cpr;
    }

    public String getName() {
        return name;
    }

    public void addAccount(IAccount account) {
        accounts.add(account);
    }
}