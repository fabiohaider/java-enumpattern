package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatusPhaseTest {
    @Test
    void testPendente() {
        assertTrue(StatusPhase.PENDENTE.podeCancelar());
        assertFalse(StatusPhase.PENDENTE.podeEnviar());
        assertEquals("#FFC107", StatusPhase.PENDENTE.getCorExibicao());
    }

    @Test
    void testPago() {
        assertTrue(StatusPhase.PAGO.podeCancelar());
        assertTrue(StatusPhase.PAGO.podeEnviar());
        assertEquals("#28A745", StatusPhase.PAGO.getCorExibicao());
    }

    @Test
    void testEnviado() {
        assertFalse(StatusPhase.ENVIADO.podeCancelar());
        assertFalse(StatusPhase.ENVIADO.podeEnviar());
        assertEquals("#007BFF", StatusPhase.ENVIADO.getCorExibicao());
    }

    @Test
    void testEntregue() {
        assertFalse(StatusPhase.ENTREGUE.podeCancelar());
        assertFalse(StatusPhase.ENTREGUE.podeEnviar());
        assertEquals("#6C757D", StatusPhase.ENTREGUE.getCorExibicao());
    }

    @Test
    void testCancelado() {
        assertFalse(StatusPhase.CANCELADO.podeCancelar());
        assertFalse(StatusPhase.CANCELADO.podeEnviar());
        assertEquals("#DC3545", StatusPhase.CANCELADO.getCorExibicao());
    }
}
