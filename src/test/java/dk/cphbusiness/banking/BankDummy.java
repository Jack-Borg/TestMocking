package dk.cphbusiness.banking;

import java.util.List;

public class BankDummy implements IBank {
    public void addAccount(IAccount account) {
        throw new UnsupportedOperationException();
    }

    public void addCustomer(ICustomer customer) {
        throw new UnsupportedOperationException();
    }

    public Account getAccount(String number) {
        throw new UnsupportedOperationException();
    }

    public List<IAccount> getAccounts(ICustomer customer) {
        throw new UnsupportedOperationException();
    }

    public ICustomer getCustomer(String cpr) {
        return null;
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }
}
