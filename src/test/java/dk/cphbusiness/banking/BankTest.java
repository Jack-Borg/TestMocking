package dk.cphbusiness.banking;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void TestGetAccountByNumber() {
        String aNumber = "ac123";
        AccountStub account = new AccountStub(aNumber, null);
        Bank bank = new Bank("","");
        bank.addAccount(account);
        assertEquals(bank.getAccount(aNumber), account);
    }

    @Test
    public void TestGetAccountsByCustomer() {
        String cpr = "cpr123";
        CustomerStub customer = new CustomerStub(cpr, "bob");
        Bank bank = new Bank("","");
        bank.addAccount(new AccountStub("", customer));
        bank.addAccount(new AccountStub("", customer));
        bank.addAccount(new AccountStub("", customer));

        assertEquals(3, bank.getAccounts(customer).size());
    }

    @Test
    public void TestGetCustomer(){
        String cpr = "cpr123";
        Bank bank = new Bank("","");
        Customer customer = new Customer(bank,cpr,"");
        bank.addCustomer(customer);

        assertEquals(customer, bank.getCustomer(cpr));
    }
}
