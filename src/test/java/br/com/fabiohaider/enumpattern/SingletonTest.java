package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class SingletonTest {
    @Test
    void testInstanciaUnica() {
        Singleton instancia1 = Singleton.INSTANCIA;
        Singleton instancia2 = Singleton.INSTANCIA;
        assertSame(instancia1, instancia2);
    }

    @Test
    void testExecutarAcaoImprimeMensagem() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        try {
            Singleton.INSTANCIA.executarAcao();
        } finally {
            System.setOut(originalOut);
        }
        String output = outContent.toString().trim();
        assertEquals("A instância Singleton está fazendo algo.", output);
    }
}
