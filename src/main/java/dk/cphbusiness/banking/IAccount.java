package dk.cphbusiness.banking;

public interface IAccount {
    IBank getBank();

    ICustomer getCustomer();

    String getNumber();

    void transfer(long amount, IAccount target, long time);

    void transfer(long amount, String targetNumber, long time);

    long getMovement(long time);

    void deposit(Movement movement);

    void withdrawal(Movement movement);
}
