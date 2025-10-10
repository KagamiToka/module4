package org.example.validation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.validation.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO implements Validator {
    private String firstName;
    private String lastName;
    private int age;

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
