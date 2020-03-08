package dk.cphbusiness.banking;

public class CustomerStub implements ICustomer {

    String cpr;
    String name;

    public CustomerStub(String cpr, String name) {
        this.cpr = cpr;
        this.name = name;
    }

    public void transfer(long amount, IAccount account, ICustomer target) {
        throw new UnsupportedOperationException();
    }

    public void transfer(long amount, IAccount sourceAccount, ICustomer target, IAccount targetAccount) {
        throw new UnsupportedOperationException();
    }

    public void addAccount(IAccount account) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IBank getBank() {
        throw new UnsupportedOperationException();
    }

    public String getCpr() {
        return cpr;
    }

    public String getName() {
        return name;
    }
}
