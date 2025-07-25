package br.com.fabiohaider.enumpattern;

import java.util.Arrays;

public enum AbstractMethod {
    ADICAO {
        @Override
        public double aplicar(double x, double y) {
            return x + y;
        }
    },
    SUBTRACAO {
        @Override
        public double aplicar(double x, double y) {
            return x - y;
        }
    },
    MULTIPLICACAO {
        @Override
        public double aplicar(double x, double y) {
            return x * y;
        }
    },
    DIVISAO {
        @Override
        public double aplicar(double x, double y) {
            if (y == 0) {
                throw new IllegalArgumentException("Não pode dividir por Zero");
            }
            return x / y;
        }
    };

    public abstract double aplicar(double x, double y);

    public static void main(String[] args) {
        var a = 10.0;
        var b = 5.0;

        Arrays.stream(values())
                .map(op -> "%f %s %f = %f".formatted(a, op, b, op.aplicar(a, b)))
                .forEach(System.out::println);

        try {
            System.out.println("10 / 0 = " + DIVISAO.aplicar(10, 0));
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
