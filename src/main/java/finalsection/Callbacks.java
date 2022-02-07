package finalsection;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {

        hello("Jo", null, value -> {
            System.out.println("no lastName provided for " + value);
        });
        System.out.println("---------------------------");

        hello2("Jo", null, () -> {
            System.out.println("no lastName provided");
        });

    }

    static void hello(String name, String lastName, Consumer<String> callback) {
        System.out.println(name);

        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(name);
        }
    }

    static void hello2(String name, String lastName, Runnable callback) {
        System.out.println(name);

        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
