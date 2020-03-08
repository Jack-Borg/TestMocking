package dk.cphbusiness.banking;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountMockingTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void testAccountTransfer() {
        final ICustomer ICustomer = context.mock(ICustomer.class);
        final IBank IBank = context.mock(IBank.class);
        final String targetNumber = "TGT1234";
        Account source = new Account(IBank, ICustomer, "SRC123");
        final Account target = new Account(IBank, ICustomer, targetNumber);
        context.checking(new Expectations() {{
            oneOf(IBank).getAccount(targetNumber);
            will(returnValue(target));
        }});

        source.transfer(10000, targetNumber, 1);
        assertEquals(-10000, source.getMovement(Long.MAX_VALUE));
        assertEquals(10000, target.getMovement(Long.MAX_VALUE));
    }

    @Test
    public void testAccountMovements() {
        final ICustomer ICustomer = context.mock(ICustomer.class);
        final IBank IBank = context.mock(IBank.class);
        Account target = new Account(IBank, ICustomer, "TRG123");
        Account source = new Account(IBank, ICustomer, "SRC123");
        target.transfer(10, source, 1);
        source.transfer(100, target, 2);
        target.transfer(1000, source, 3);

        assertEquals(910, source.getMovement(Long.MAX_VALUE));
        assertEquals(10, source.getMovement(1));
        assertEquals(-90, source.getMovement(2));
        assertEquals(910, source.getMovement(3));
    }
}
