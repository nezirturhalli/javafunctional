package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        Customer dodo = new Customer("Dodo", "9999999999");

        greetCustomer(dodo);
        greetCustomerV2(dodo, false);
        greetCustomerConsumer.accept(dodo);
        greetCustomerConsumerV2.accept(dodo, false);

    }


    //TODO Consumer part


    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Welcome " + customer.name +
                    " and your phone number is " + customer.phone);
    //TODO BiConsumer part

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Welcome " + customer.name +
                    " and your phone number is " + (showPhoneNumber ? customer.phone : "***********"));

    static void greetCustomer(Customer customer) {

        System.out.println("Welcome " + customer.name +
                " and your phone number is " + customer.phone);

    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Welcome " + customer.name +
                " and your phone number is " + (showPhoneNumber ? customer.phone : "***********"));
    }

    static class Customer {
        private final String name;
        private final String phone;

        Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
