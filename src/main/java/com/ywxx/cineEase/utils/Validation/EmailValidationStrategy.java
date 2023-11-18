package com.ywxx.cineEase.utils.Validation;

import com.ywxx.cineEase.utils.RegexUtils;

public class EmailValidationStrategy implements ValidationStrategy {
    @Override
    public boolean isValid(String email) {

        return !RegexUtils.isEmailInvalid(email);
    }
}
