package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StateMachineTest {
    @Test
    void testProximo() {
        assertEquals(StateMachine.VERDE, StateMachine.VERMELHO.proximo());
        assertEquals(StateMachine.AMARELO, StateMachine.VERDE.proximo());
        assertEquals(StateMachine.VERMELHO, StateMachine.AMARELO.proximo());
    }

    @Test
    void testAcao() {
        assertEquals("Parar", StateMachine.VERMELHO.acao());
        assertEquals("Avançar", StateMachine.VERDE.acao());
        assertEquals("Cuidado", StateMachine.AMARELO.acao());
    }
}
