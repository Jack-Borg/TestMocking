package dk.cphbusiness.banking;

public interface ICustomer {
    void transfer(long amount, IAccount sourceAccount, ICustomer target, IAccount targetAccount);
    void addAccount(IAccount account);

    IBank getBank();
    String getCpr();
    String getName();
}
