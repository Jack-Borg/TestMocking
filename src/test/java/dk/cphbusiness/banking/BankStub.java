package dk.cphbusiness.banking;

import java.util.List;

public class BankStub implements IBank {

    private Account account;

    public BankStub(){
    }

    @Override
    public void addAccount(IAccount account) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addCustomer(ICustomer customer) {
        throw new UnsupportedOperationException();
    }

    public Account getAccount(String number) {
        return account;
    }

    public List<IAccount> getAccounts(ICustomer customer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ICustomer getCustomer(String cpr) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    void setAccount(Account account){
        this.account = account;
    }
}
