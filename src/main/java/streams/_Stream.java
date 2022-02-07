package streams;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {

        List<Person> personList = List.of(

                new Person("Ali", MALE),
                new Person("Nezir", MALE),
                new Person("Alixe", FEMALE),
                new Person("Özge", FEMALE),
                new Person("Emine", FEMALE),
                new Person("John", MALE),
                new Person("Kipa", PREFER_NOT_TO_SAY)
        );

        personList.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("-------------------");

        personList.stream()
                .map(person -> person.name)
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("-------------------");

// TODO (ctrl + alt+ v) extract -> variable
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        personList.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        System.out.println("-------------------");

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        boolean containsOnlyFemale = personList.stream()
                .allMatch(personPredicate);
        System.out.println(containsOnlyFemale);

    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Person {
        private String name;
        private Gender gender;
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
