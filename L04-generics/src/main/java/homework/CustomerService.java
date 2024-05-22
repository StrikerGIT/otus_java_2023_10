package homework;

import java.util.AbstractMap;
import java.util.TreeMap;
import java.util.Map;

public class CustomerService {
    private final TreeMap<Customer, String> customers = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        if (customers.isEmpty()) {
            return null;
        }
        Map.Entry<Customer, String> firstEntry = customers.firstEntry();
        return getNewCustomer(firstEntry.getKey(), firstEntry.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> nextEntry = customers.higherEntry(customer);
        if (nextEntry == null) {
            return null;
        }
        return getNewCustomer(nextEntry.getKey(), nextEntry.getValue());
    }

    public void add(Customer customer, String data) {
        customers.putIfAbsent(customer, data);
    }

    private  Map.Entry<Customer, String> getNewCustomer(Customer customer, String data) {
        return new AbstractMap.SimpleEntry<>(
                new Customer(customer.getId(), customer.getName(), customer.getScores()),
                data
        );
    }
}
