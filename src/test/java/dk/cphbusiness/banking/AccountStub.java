package dk.cphbusiness.banking;

public class AccountStub implements IAccount {
    String number;
    ICustomer customer;

    public AccountStub(String number, ICustomer customer) {
        this.number = number;
        this.customer = customer;
    }

    public IBank getBank() {
        throw new UnsupportedOperationException();
    }

    public ICustomer getCustomer() {
        return customer;
    }

    public String getNumber() {
        return number;
    }

    public void transfer(long amount, IAccount target, long time) {
        throw new UnsupportedOperationException();
    }

    public void transfer(long amount, String targetNumber,long time) {
        throw new UnsupportedOperationException();
    }

    public long getMovement(long his) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deposit(Movement movement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void withdrawal(Movement movement) {
        throw new UnsupportedOperationException();
    }
}
