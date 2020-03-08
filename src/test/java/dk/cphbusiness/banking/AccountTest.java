package dk.cphbusiness.banking;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void testCreatAccount() throws Exception {
        IBank IBank = null;
        ICustomer ICustomer = null;
        String number = null;
        Account account = new Account(IBank, ICustomer, number);
        assertNotNull(account);
    }

    @Test
    public void testCreateAccountWithBank() {
        IBank IBank = new BankDummy();
        ICustomer ICustomer = null;
        String number = null;
        Account account = new Account(IBank, ICustomer, number);
        assertEquals(IBank, account.getBank());
    }

    @Test
    public void testCreateAccountWithCustomer() {
        IBank IBank = new BankDummy();
        ICustomer ICustomer = new CustomerDummy();
        String number = null;
        Account account = new Account(IBank, ICustomer, number);
        assertEquals(ICustomer, account.getCustomer());
    }

    @Test
    public void testCreateAccountWithNumber() {
        IBank IBank = new BankDummy();
        ICustomer ICustomer = new CustomerDummy();
        String number = "123456";
        Account account = new Account(IBank, ICustomer, number);
        assertEquals(number, account.getNumber());
    }

    @Test
    public void testCreateAccountWithZeroBalance() {
        IBank IBank = new BankDummy();
        ICustomer ICustomer = new CustomerDummy();
        String number = "123456";
        Account account = new Account(IBank, ICustomer, number);
        assertEquals(0, account.getMovement(Long.MAX_VALUE));
    }

    @Test
    public void testTransferPositiveAmount() {
        IBank IBank = new BankDummy();
        ICustomer ICustomer = new CustomerDummy();
        Account source = new Account(IBank, ICustomer, "SRC23");
        Account target = new Account(IBank, ICustomer, "TRT123");
        source.transfer(10000, target, 1);
        assertEquals(-10000, source.getMovement(Long.MAX_VALUE));
        assertEquals(10000, target.getMovement(Long.MAX_VALUE));
    }

    @Test
    public void testTransferPositiveAmountUsingNumber() {
        IBank IBankDummy = new BankDummy();
        BankStub bankStub = new BankStub();
        ICustomer ICustomer = new CustomerDummy();
        Account target = new Account(IBankDummy, ICustomer, "TRT123");
        Account source = new Account(bankStub, ICustomer, "SRC123");
        bankStub.setAccount(target);
        source.transfer(10000, "TRT123", 1);
        assertEquals(-10000, source.getMovement(Long.MAX_VALUE));
        assertEquals(10000, target.getMovement(Long.MAX_VALUE));
    }
}
