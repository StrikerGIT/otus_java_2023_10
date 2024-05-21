package homework;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private HashMap<Customer, String> customers = new HashMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        return customers.entrySet().stream()
                .min(Comparator.comparingLong(e -> e.getKey().getScores()))
                .map(e -> new AbstractMap.SimpleEntry<>(
                        new Customer(
                                e.getKey().getId(),
                                e.getKey().getName(),
                                e.getKey().getScores()),
                        e.getValue()))
                .orElse(null);
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return customers.entrySet().stream()
                .filter(e -> e.getKey().getScores() > customer.getScores())
                .min(Comparator.comparingLong(e -> e.getKey().getScores()))
                .map(e -> new AbstractMap.SimpleEntry<>(
                        new Customer(
                                e.getKey().getId(),
                                e.getKey().getName(),
                                e.getKey().getScores()),
                        e.getValue()))
                .orElse(null);
    }

    public void add(Customer customer, String data) {
        customers.putIfAbsent(customer, data);
    }
}
