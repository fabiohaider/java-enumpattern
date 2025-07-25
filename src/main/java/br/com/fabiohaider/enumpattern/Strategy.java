package br.com.fabiohaider.enumpattern;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Strategy {
    SOMAR(Integer::sum),
    SUBTRAIR((a, b) -> a - b),
    MULTIPLICAR((a, b) -> a * b),
    DIVIDIR((a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("Não pode dividir por Zero");
        }
        return a / b;
    });

    private final IntBinaryOperator operador;

    Strategy(IntBinaryOperator operador) {
        this.operador = operador;
    }

    public int aplicar(int a, int b) {
        return operador.applyAsInt(a, b);
    }

    public static void main(String[] args) {
        var x = 10;
        var y = 5;

        Arrays.stream(Strategy.values())
                .forEach(strategy -> System.out.printf("%d %s %d = %d%n", x, strategy.name(), y, strategy.aplicar(x, y)));
    }
}