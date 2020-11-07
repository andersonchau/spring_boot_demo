package com.and.demo.webappall.base.validator;

import com.and.demo.webappall.base.dto.JobForm;
import com.and.demo.webappall.base.dto.LoginInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class JobFormValidator implements Validator {
    @Override
    public boolean supports(Class clazz) {
        return JobForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JobForm j = (JobForm) target;
        System.out.println();
        String desc = j.getDescription();
        int status = j.getStatus();
        String deadStr = j.getDeadline();
        if (StringUtils.isEmpty(desc) ||
                StringUtils.isBlank(desc)
        ) {
                errors.rejectValue("description", "error.input.job.mustNotBeBlank");
        }
        if (status!=1 && status !=2) {
            errors.rejectValue("status", "error.input.job.pleaseSelJobStatus");
        }
        if(!isValidDateStr(deadStr)) {
            errors.rejectValue("deadline", "error.input.job.deadLineError");
        }
        /*
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
         */

    }

    boolean isValidDateStr(String dateStr){
        if ( dateStr == null || dateStr.length() == 0 ) return false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse(dateStr);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
