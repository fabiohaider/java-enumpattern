package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class DecisionTableTest {
    @Test
    void testClientePlatinum() {
        BigDecimal valor = new BigDecimal("200.00");
        assertEquals(0, new BigDecimal("30.00").compareTo(DecisionTable.CLIENTE_PLATINUM.calculaDesconto(valor, true)));
        assertEquals(0, new BigDecimal("30.00").compareTo(DecisionTable.CLIENTE_PLATINUM.calculaDesconto(valor, false)));
    }

    @Test
    void testClienteGold() {
        BigDecimal valor = new BigDecimal("200.00");
        assertEquals(0, new BigDecimal("20.00").compareTo(DecisionTable.CLIENTE_GOLD.calculaDesconto(valor, true)));
        assertEquals(0, new BigDecimal("10.00").compareTo(DecisionTable.CLIENTE_GOLD.calculaDesconto(valor, false)));
    }

    @Test
    void testClienteSilver() {
        BigDecimal valor = new BigDecimal("200.00");
        assertEquals(0, new BigDecimal("4.00").compareTo(DecisionTable.CLIENTE_SILVER.calculaDesconto(valor, true)));
        assertEquals(0, new BigDecimal("4.00").compareTo(DecisionTable.CLIENTE_SILVER.calculaDesconto(valor, false)));
    }

    @Test
    void testClienteRegular() {
        BigDecimal valor = new BigDecimal("200.00");
        assertEquals(0, new BigDecimal("6.00").compareTo(DecisionTable.CLIENTE_REGULAR.calculaDesconto(valor, true)));
        assertEquals(0, BigDecimal.ZERO.compareTo(DecisionTable.CLIENTE_REGULAR.calculaDesconto(valor, false)));
    }
}
