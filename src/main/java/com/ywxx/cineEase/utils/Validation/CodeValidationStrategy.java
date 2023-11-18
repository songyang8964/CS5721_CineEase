package com.ywxx.cineEase.utils.Validation;

import com.ywxx.cineEase.utils.RegexUtils;

public class CodeValidationStrategy implements ValidationStrategy {
    @Override
    public boolean isValid(String code) {

        return !RegexUtils.isCodeInvalid(code);
    }
}
