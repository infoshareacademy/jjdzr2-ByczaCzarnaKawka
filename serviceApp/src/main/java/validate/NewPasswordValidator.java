package validate;

import domain.users.UserDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static utils.Tools.isPasswordsMatch;

public class NewPasswordValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz){
        return UserDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        UserDTO userDTO=(UserDTO) target;
        if(isPasswordsMatch(userDTO.getPassword(), userDTO.getRepeatPassword())){
            errors.reject("passwords do not match");
        }
    }

}
