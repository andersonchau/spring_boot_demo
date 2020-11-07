package com.and.demo.webappall.base.validator;

import com.and.demo.webappall.base.dto.LoginInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginFormValidator  implements Validator
{
    @Override
    public boolean supports(Class clazz) {
        return LoginInfo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginInfo loginInfo = (LoginInfo) target;
        System.out.println();
        String u = loginInfo.getUsername();
        String p  = loginInfo.getPassword();
        // use REGEX , now just some logics for demonstration
        if( StringUtils.isEmpty(p) ||
        StringUtils.isBlank(p)||
                StringUtils.containsWhitespace(p)||
                StringUtils.length(p) < 8 ) {
            errors.rejectValue("password", "error.input.login.invalidPassword");
        }
        if( StringUtils.isEmpty(u) ||
                StringUtils.containsWhitespace(u)||
                StringUtils.isBlank(u)||
                StringUtils.length(u) < 8 ) {
            errors.rejectValue("username", "error.input.login.invalidUsername");
        }
        if(!errors.hasErrors()) {
            if (!u.equals(p)) {
                errors.rejectValue("confirmPassword", "error.input.login.invalidConfirmPassword");
            }
        }

    }
}
