package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("+900000000000"));
        System.out.println(isPhoneNumberValid("+9100000"));
        System.out.println("-----------------------------");
        System.out.println(isPhoneNumberValidPredicate.test("+900000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("90000"));

        System.out.println("----------------------------");
        System.out.println(isPhoneNumberValidPredicate.and(contain7).test("+900000074321"));
        System.out.println(isPhoneNumberValidPredicate.or(contain7).test("+900000004321"));


    }

    //TODO Predicate Part (Boolean logic)
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("+90") && phoneNumber.length() == 13;

    static Predicate<String> contain7 = phoneNumber ->
            phoneNumber.contains("7");

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+90") && phoneNumber.length() == 13;
    }
}
