package org.example.validation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getFirstName() == null || user.getFirstName().equals("") || user.getFirstName().equals(" ")) {
            errors.rejectValue("firstName", null, "First name is required");
        } else if (user.getLastName() == null || user.getLastName().equals("") || user.getLastName().equals(" ")) {
            errors.rejectValue("lastName", null, "Last name is required");
        } else if (user.getAge() < 18) {
            errors.rejectValue("age", null, "Age need to be equal or greater than 18");
        } else if (user.firstName.length() > 4 && user.firstName.length() < 46) {
            errors.rejectValue("firstName", null, "First name has to be between 4 and 46 characters");
        } else if (user.lastName.length() > 4 && user.lastName.length() < 46) {
            errors.rejectValue("lastName", null, "Last name has to be between 4 and 46 characters");
        }
    }
}
