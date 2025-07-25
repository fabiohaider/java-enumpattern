package br.com.fabiohaider.enumpattern;

import java.util.stream.Stream;

public enum StateMachine {
    VERMELHO,
    VERDE,
    AMARELO;

    public StateMachine proximo() {
        return switch (this) {
            case VERMELHO -> VERDE;
            case VERDE -> AMARELO;
            case AMARELO -> VERMELHO;
        };
    }

    public String acao() {
        return switch (this) {
            case VERMELHO -> "Parar";
            case VERDE -> "Avançar";
            case AMARELO -> "Cuidado";
        };
    }

    public static void main(String[] args) {
        int fases = (args.length > 0) ? Integer.parseInt(args[0]) : 6;

        Stream.iterate(VERMELHO, StateMachine::proximo)
                .limit(fases)
                .forEach(light ->
                        System.out.printf("Light: %s, Action: %s%n", light, light.acao())
                );
    }
}
