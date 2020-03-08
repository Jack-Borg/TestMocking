package dk.cphbusiness.banking;

public class Movement {
    IAccount source;
    IAccount target;
    long amount;
    long timestamp;

    public Movement(IAccount source, IAccount target, long amount, long timestamp){
        this.source = source;
        this.target = target;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public long getAmount() {
        return amount;
    }
}
