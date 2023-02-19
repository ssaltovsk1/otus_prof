package ru.otus;


import javax.net.ssl.SSLContext;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private static Map<Customer, String> customersMap = new HashMap<>();
    private static NavigableMap<Customer, String> mapToGetNext = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {

        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> customerWithSmallestScore = null;

        for (Map.Entry<Customer, String> entry : customersMap.entrySet()) {
            if (customerWithSmallestScore == null || entry.getKey().getScores() < customerWithSmallestScore.getKey().getScores()) {
                customerWithSmallestScore = entry;
            }
        }

        return antiMutationCopyOfMapEntry(customerWithSmallestScore);
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {

        mapToGetNext.putAll(Map.copyOf(customersMap));

        if ((mapToGetNext.higherEntry(customer) == null)) {
            return null;
        }

        return antiMutationCopyOfMapEntry(mapToGetNext.higherEntry(customer));
    }

    public void add(Customer customer, String data) { customersMap.put(customer, data); }

    public Map.Entry<Customer, String> antiMutationCopyOfMapEntry(Map.Entry<Customer, String> mapEntry) {

        Customer key = mapEntry.getKey();
        String value = mapEntry.getValue();

        long id = key.getId();
        String name = key.getName();
        long scores = key.getScores();

        return new AbstractMap.SimpleEntry<>(new Customer(id, name, scores), value);

    }

}
