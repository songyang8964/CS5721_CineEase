package com.ywxx.cineEase.utils.Validation;

import com.ywxx.cineEase.utils.RegexUtils;

public class PhoneValidationStrategy implements ValidationStrategy {
    @Override
    public boolean isValid(String phone) {

        return !RegexUtils.isPhoneInvalid(phone);
    }
}

