package dk.cphbusiness.banking;

import java.util.ArrayList;
import java.util.List;

public interface IBank {
    public void addAccount(IAccount account);

    public void addCustomer(ICustomer customer);

    public IAccount getAccount(String number);

    public List<IAccount> getAccounts(ICustomer customer);

    public ICustomer getCustomer(String cpr);
}
