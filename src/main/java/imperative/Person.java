package imperative;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

        private String name;
        private Gender gender;
}

enum Gender {
    MALE, FEMALE
}