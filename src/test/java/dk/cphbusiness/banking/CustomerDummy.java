package dk.cphbusiness.banking;

import org.jmock.lib.concurrent.UnsupportedSynchronousOperationException;

public class CustomerDummy implements ICustomer {

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
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }
}
