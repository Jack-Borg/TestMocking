package dk.cphbusiness.banking;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankTool {
    public IBank handleLines(Bank bank, String[] lines) throws IOException {
        for (String line : lines) {
            String[] parts = line.split(":");
            switch (parts[0]){
                case "A":
                    bank.addAccount(AccountFromParts(parts, bank));
                    break;
                case "C":
                    bank.addCustomer(CustomerFromParts(parts, bank));
                    break;
                case "M":
                    MovementFromParts(parts, bank);
                    break;
            }
        }
        return bank;
    }

    public List<String> linesFromFile(String filename) throws IOException {
        return Files.readAllLines(Path.of(filename));
    }

    public static ICustomer CustomerFromParts(String[] parts, IBank bank) {
        if (parts.length != 3) throw new RuntimeException();
        ICustomer customer = new Customer(bank, parts[1], parts[2]);
        return customer;
    }

    public static IAccount AccountFromParts(String[] parts, IBank bank) {
        if (parts.length != 3) throw new RuntimeException();
        Account account = new Account(bank, bank.getCustomer(parts[1]), parts[2]);
        return account;
    }

    public static void MovementFromParts(String[] parts, IBank bank) {
        if (parts.length != 5) throw new RuntimeException();
        IAccount source = bank.getAccount(parts[1]);
        IAccount target = bank.getAccount(parts[2]);
        long amount = Integer.parseInt(parts[3]);
        long timestamp = Integer.parseInt(parts[4]);
        source.transfer(amount, target, timestamp);
    }
}