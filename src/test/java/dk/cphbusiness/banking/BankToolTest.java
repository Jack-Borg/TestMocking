package dk.cphbusiness.banking;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class BankToolTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void TestCustomerFromParts() {
        String[] parts = {"C", "cpr123", "bob"};
        IBank bank = context.mock(IBank.class);
        ICustomer customer = BankTool.CustomerFromParts(parts, bank);

        assertEquals(customer.getCpr(), parts[1]);
        assertEquals(customer.getName(), parts[2]);
        assertEquals(customer.getBank(), bank);
    }

    @Test
    public void TestAccountFromParts() {
        String[] parts = {"A", "cpr123", "src1232"};
        IBank bank = context.mock(IBank.class);
        ICustomer customer = context.mock(ICustomer.class);
        context.checking(new Expectations() {{
            oneOf(bank).getCustomer(parts[1]);
            will(returnValue(customer));
        }});

        IAccount account = BankTool.AccountFromParts(parts, bank);

        assertEquals(account.getNumber(), parts[2]);
        assertEquals(customer, account.getCustomer());
    }

    @Test
    public void TestMovementFromParts() {
        String[] parts = {"M", "src123", "tgt321", "100", "1"};
        String sourceNumber = parts[1];
        String targetNumber = parts[2];
        ICustomer customer = context.mock(ICustomer.class);
        Bank bank = new Bank("123", "bank");
        bank.addAccount(new Account(bank, customer, sourceNumber));
        bank.addAccount(new Account(bank, customer, targetNumber));
        BankTool.MovementFromParts(parts, bank);

        assertEquals(bank.getAccount(sourceNumber).getMovement(1), -100);
        assertEquals(bank.getAccount(targetNumber).getMovement(1), 100);
    }
}
