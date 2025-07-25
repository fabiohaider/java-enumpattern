package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {
    @Test
    void testSomar() {
        assertEquals(7, Strategy.SOMAR.aplicar(3, 4));
    }

    @Test
    void testSubtrair() {
        assertEquals(1, Strategy.SUBTRAIR.aplicar(5, 4));
    }

    @Test
    void testMultiplicar() {
        assertEquals(20, Strategy.MULTIPLICAR.aplicar(4, 5));
    }

    @Test
    void testDividir() {
        assertEquals(2, Strategy.DIVIDIR.aplicar(10, 5));
    }

    @Test
    void testDividirPorZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Strategy.DIVIDIR.aplicar(10, 0);
        });
        assertEquals("Não pode dividir por Zero", exception.getMessage());
    }
}
