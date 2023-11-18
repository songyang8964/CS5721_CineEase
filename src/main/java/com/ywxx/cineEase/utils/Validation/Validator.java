package com.ywxx.cineEase.utils.Validation;

public class Validator {
    private ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String input) {
        return strategy.isValid(input);
    }
}
