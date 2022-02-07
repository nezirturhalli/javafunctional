package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(
                "Dodo",
                "dodogmail.com",
                "+0999999999",
                LocalDate.of(2000, 1, 1));


        // System.out.println(new CustomerValidatorService().isValid(customer));

        // Using combinator pattern

        ValidationResult result = isEmailValid().
                and(isPhoneNumberValid()).
                and(isAdult()).apply(customer);


        if (result == SUCCESS) {
            System.out.println(result);
        } else {
            throw new IllegalStateException(result.name());
        }
    }
}
