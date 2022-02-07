package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        int increment1 = incrementByOne(1);
        System.out.println(increment1);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        int i = addBy1AndMultiply10Function.apply(3);
        System.out.println(i);

        int j = incrementByOneAndMultiplyBiFunction.apply(2, 5);
        System.out.println(j);
    }


    //  TODO Function
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static Function<Integer, Integer> addBy1AndMultiply10Function = incrementByOneFunction.andThen(multiplyBy10Function);

    static int incrementByOne(int number) {

        return number + 1;
    }

    // TODO BiFunction
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementBy, numberToMultiplyBy) -> (numberToIncrementBy + 1) * numberToMultiplyBy;

    static int incrementBy1AndMultiply(int number, int numToMultiply) {

        return (number + 1) * numToMultiply;
    }
}
