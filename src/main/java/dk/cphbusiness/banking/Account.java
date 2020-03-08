package dk.cphbusiness.banking;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {
    private IBank bank;
    private ICustomer ICustomer;
    private String number;
    private List<Movement> withdrawals;
    private List<Movement> deposits;


    public Account(IBank IBank, ICustomer ICustomer, String number) {
        this.bank = IBank;
        this.ICustomer = ICustomer;
        this.number = number;
        withdrawals = new ArrayList<>();
        deposits = new ArrayList<>();
    }

    public IBank getBank() {
        return bank;
    }

    public ICustomer getCustomer() {
        return ICustomer;
    }

    public String getNumber() {
        return number;
    }

    public void transfer(long amount, IAccount target, long time) {
        Movement movement = new Movement(this, target, amount, time);
        target.deposit(movement);
        withdrawal(movement);
    }

    public void transfer(long amount, String targetNumber, long time) {
        IAccount target = bank.getAccount(targetNumber);
        transfer(amount, target, time);
    }

    public long getMovement(long time) {
        long res = 0;
        for (Movement m : deposits) {
            if (m.timestamp <= time)
                res += m.getAmount();
        }
        for (Movement m : withdrawals) {
            if (m.timestamp <= time)
                res -= m.getAmount();
        }

        return res;
    }

    @Override
    public void deposit(Movement movement) {
        deposits.add(movement);
    }

    @Override
    public void withdrawal(Movement movement) {
        withdrawals.add(movement);
    }
}
