package ru.otus;


import java.util.*;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    List<Customer> customerReverseOrder = new ArrayList<>();

    public void add(Customer customer) {
        customerReverseOrder.add(customer);
    }

    public Customer take() {
        System.out.println(customerReverseOrder);
        Customer customer = customerReverseOrder.get(customerReverseOrder.size() - 1);
        customerReverseOrder.remove(customerReverseOrder.size() - 1);
        return customer;
    }
}
