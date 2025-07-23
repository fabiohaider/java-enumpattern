package br.com.fabiohaider.enumpattern;

import java.util.function.Predicate;

public enum ConfigurableValidators {
    IS_NUMERIC(input -> input != null && input.matches("\\d+")),
    IS_EMAIL(input -> input != null && input.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")),
    IS_NOT_EMPTY(input -> input != null && !input.trim().isEmpty());

    private final Predicate<String> validationFunction;

    ConfigurableValidators(Predicate<String> validationFunction) {
        this.validationFunction = validationFunction;
    }

    public boolean validate(String input) {
        return validationFunction.test(input);
    }

    public static void main(String[] args) {
        String testInput = "user@example.com";
        boolean isEmailValid = ConfigurableValidators.IS_EMAIL.validate(testInput);
        System.out.println("Is valid email? " + isEmailValid);

        System.out.println("Null test: " + ConfigurableValidators.IS_NOT_EMPTY.validate(null));
    }
}