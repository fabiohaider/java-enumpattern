package br.com.fabiohaider.enumpattern;

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
        StateMachine light = RED;
        for (int i = 0; i < 6; i++) {
            System.out.println("Light: " + light + ", Action: " + light.action());
            light = light.next();
        }
    }
}
