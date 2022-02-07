package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Gender.*;


public class Main {
    public static void main(String[] args) {

        List<Person> personList = List.of(
                new Person("Ali", MALE),
                new Person("Nezir", MALE),
                new Person("Ayşe", FEMALE),
                new Person("Özge", FEMALE),
                new Person("Emine", FEMALE)
        );
        System.out.println("----------------IMPERATIVE APPROACH----------------");
        // TODO 1
        // Imperative Approach

        List<Person> females = new ArrayList<>();
        for (Person person : personList) {
            if (FEMALE.equals(person.getGender())) {
                females.add(person);
            }
        }
        //System.out.println(females);
        for (Person female : females) {
            System.out.println(female);

        }

        System.out.println("----------------DECLARATIVE APPROACH----------------");

        // TODO 2
        // Declarative Approach

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.getGender());
        List<Person> females2 = personList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        females2.forEach(System.out::println);


    }

}

