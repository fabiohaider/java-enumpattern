package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class FactoryTest {
    @Test
    void testCriarRetornaInstanciaCorreta() {
        assertTrue(Factory.CIRCULO.criar() instanceof Circulo);
        assertTrue(Factory.QUADRADO.criar() instanceof Quadrado);
        assertTrue(Factory.TRIANGULO.criar() instanceof Triagulo);
    }

    @Test
    void testDesenhaImprimeMensagemCorreta() {
        assertDesenhaPrints(new Circulo(), "Desenhando um Círculo");
        assertDesenhaPrints(new Quadrado(), "Desenhando um Quadrado");
        assertDesenhaPrints(new Triagulo(), "Desenhando um Triangulo");
    }

    private void assertDesenhaPrints(Forma forma, String expectedMessage) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        try {
            forma.desenha();
        } finally {
            System.setOut(originalOut);
        }
        String output = outContent.toString().trim();
        assertEquals(expectedMessage, output);
    }
}
