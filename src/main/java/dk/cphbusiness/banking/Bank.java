package dk.cphbusiness.banking;

import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {

    List<IAccount> accounts;
    List<ICustomer> customers;
    String cvr;
    String name;


    public Bank(String cvr, String name) {
        accounts = new ArrayList();
        customers = new ArrayList();
        this.cvr = cvr;
        this.name = name;
    }

    public void addAccount(IAccount account) {
        accounts.add(account);
    }

    public void addCustomer(ICustomer customer) {
        customers.add(customer);
    }

    public IAccount getAccount(String number) {
        for (IAccount a : accounts) {
            if (a.getNumber() == number)
                return a;
        }
        return null;
    }

    public List<IAccount> getAccounts(ICustomer customer) {
        List<IAccount> list = new ArrayList();
        for (IAccount a : accounts) {
            if (a.getCustomer().getCpr() == customer.getCpr())
                list.add(a);
        }
        return list;
    }

    public ICustomer getCustomer(String cpr){
        for (ICustomer c : customers) {
            if (c.getCpr() == cpr)
                return c;
        }
        return null;
    }

}
