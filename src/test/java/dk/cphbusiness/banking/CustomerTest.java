package dk.cphbusiness.banking;

import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void TestAddAccount(){
        /*ICustomer customer = new Customer("cpr","bob");
        IAccount account = context.mock(IAccount.class);
        customer.addAccount(account);
        customer.addAccount(account);
        customer.addAccount(account);
        customer.addAccount(account);

        assertEquals(4, customer.accounts);*/
    }
}
