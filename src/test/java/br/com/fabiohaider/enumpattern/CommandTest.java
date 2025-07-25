package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CommandTest {
    @Test
    void testAPartirDeString_ValidCommands() {
        assertEquals(Command.INICIAR, Command.aPartirDeString("iniciar"));
        assertEquals(Command.PARAR, Command.aPartirDeString("PARAR"));
        assertEquals(Command.REINICIAR, Command.aPartirDeString("Reiniciar"));
    }

    @Test
    void testAPartirDeString_InvalidCommand() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            Command.aPartirDeString("desconhecido");
        });
        assertTrue(exception.getMessage().contains("Unsupported command"));
    }

    @Test
    void testExecute_PrintsCorrectMessage() {
        assertCommandPrints(Command.INICIAR, "O sistema está iniciando ...");
        assertCommandPrints(Command.PARAR, "O sistema está parando ...");
        assertCommandPrints(Command.REINICIAR, "O sistema está reiniciando ...");
    }

    private void assertCommandPrints(Command command, String expectedMessage) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        try {
            command.execute();
        } finally {
            System.setOut(originalOut);
        }
        String output = outContent.toString().trim();
        assertEquals(expectedMessage, output);
    }
}
