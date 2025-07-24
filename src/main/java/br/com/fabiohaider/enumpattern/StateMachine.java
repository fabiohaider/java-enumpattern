package br.com.fabiohaider.enumpattern;

import java.util.stream.Stream;

public enum StateMachine {
    RED,
    GREEN,
    YELLOW;

    public StateMachine next() {
        return switch (this) {
            case RED -> GREEN;
            case GREEN -> YELLOW;
            case YELLOW -> RED;
        };
    }

    public String action() {
        return switch (this) {
            case RED -> "Stop";
            case GREEN -> "Go";
            case YELLOW -> "Caution";
        };
    }

    public static void main(String[] args) {
        // Número de ciclos como argumento (default 6)
        int cycles = (args.length > 0) ? Integer.parseInt(args[0]) : 6;

        Stream.iterate(RED, StateMachine::next)
                .limit(cycles)
                .forEach(light ->
                        System.out.printf("Light: %s, Action: %s%n", light, light.action())
                );
    }
}
