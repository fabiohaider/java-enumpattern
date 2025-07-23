package br.com.fabiohaider.enumpattern;

public enum Command {
    START(() -> System.out.println("System is starting...")),
    STOP(() -> System.out.println("System is stopping...")),
    RESTART(() -> System.out.println("System is restarting..."));

    private final Runnable executor;

    Command(Runnable executor) {
        this.executor = executor;
    }

    public void execute() {
        executor.run();
    }

    public static Command fromString(String commandStr) {
        try {
            return Command.valueOf(commandStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new UnsupportedOperationException("Unsupported command: " + commandStr);
        }
    }

    public static void main(String[] args) {
        Command cmd = Command.fromString(Command.START.name());
        cmd.execute();
    }
}