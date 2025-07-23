package br.com.fabiohaider.enumpattern;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Strategy {
    ADD(Integer::sum),
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVIDE((a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    });

    private final IntBinaryOperator operator;

    Strategy(IntBinaryOperator operator) {
        this.operator = operator;
    }

    public int apply(int a, int b) {
        return operator.applyAsInt(a, b);
    }

    public static void main(String[] args) {
        var x = 10;
        var y = 5;

        Arrays.stream(Strategy.values()).forEach(strategy -> System.out.printf("%d %s %d = %d%n", x, strategy.name(), y, strategy.apply(x, y)));
    }
}