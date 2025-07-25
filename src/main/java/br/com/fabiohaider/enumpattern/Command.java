package br.com.fabiohaider.enumpattern;

public enum Command {
    INICIAR(() -> System.out.println("O sistema está iniciando ...")),
    PARAR(() -> System.out.println("O sistema está parando ...")),
    REINICIAR(() -> System.out.println("O sistema está reiniciando ..."));

    private final Runnable executor;

    Command(Runnable executor) {
        this.executor = executor;
    }

    public void execute() {
        executor.run();
    }

    public static Command aPartirDeString(String commandStr) {
        try {
            return Command.valueOf(commandStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new UnsupportedOperationException("Unsupported command: " + commandStr);
        }
    }

    public static void main(String[] args) {
        Command cmd = Command.aPartirDeString(Command.INICIAR.name());
        cmd.execute();
    }
}