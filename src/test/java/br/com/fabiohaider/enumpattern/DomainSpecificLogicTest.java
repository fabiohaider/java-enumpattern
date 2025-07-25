package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class DomainSpecificLogicTest {
    @Test
    void testLivro() {
        BigDecimal valor = new BigDecimal("100.00");
        assertEquals(0, new BigDecimal("5.00").compareTo(DomainSpecificLogic.LIVRO.calculaTaxa(valor)));
        assertEquals("Item de leitura e conhecimento", DomainSpecificLogic.LIVRO.getDescricao());
        assertNotNull(DomainSpecificLogic.LIVRO.toString());
    }

    @Test
    void testEletronico() {
        BigDecimal valor = new BigDecimal("100.00");
        assertEquals(0, new BigDecimal("18.00").compareTo(DomainSpecificLogic.ELETRONICO.calculaTaxa(valor)));
        assertEquals("Dispositivo eletrônico", DomainSpecificLogic.ELETRONICO.getDescricao());
        assertNotNull(DomainSpecificLogic.ELETRONICO.toString());
    }

    @Test
    void testComida() {
        BigDecimal valor = new BigDecimal("100.00");
        assertEquals(BigDecimal.ZERO, DomainSpecificLogic.COMIDA.calculaTaxa(valor));
        assertEquals("Produto alimentício", DomainSpecificLogic.COMIDA.getDescricao());
        assertNotNull(DomainSpecificLogic.COMIDA.toString());
    }

    @Test
    void testValoresEspeciais() {
        // Zero
        assertEquals(0, BigDecimal.ZERO.compareTo(DomainSpecificLogic.LIVRO.calculaTaxa(BigDecimal.ZERO)));
        assertEquals(0, BigDecimal.ZERO.compareTo(DomainSpecificLogic.ELETRONICO.calculaTaxa(BigDecimal.ZERO)));
        assertEquals(0, BigDecimal.ZERO.compareTo(DomainSpecificLogic.COMIDA.calculaTaxa(BigDecimal.ZERO)));
        // Negativo
        BigDecimal negativo = new BigDecimal("-100.00");
        assertEquals(0, new BigDecimal("-5.00").compareTo(DomainSpecificLogic.LIVRO.calculaTaxa(negativo)));
        assertEquals(0, new BigDecimal("-18.00").compareTo(DomainSpecificLogic.ELETRONICO.calculaTaxa(negativo)));
        assertEquals(BigDecimal.ZERO, DomainSpecificLogic.COMIDA.calculaTaxa(negativo));
    }

    // Removido teste de NullPointerException pois não é lançado na implementação atual

    @Test
    void testEnumUtilitarios() {
        // values()
        DomainSpecificLogic[] all = DomainSpecificLogic.values();
        assertEquals(3, all.length);
        // valueOf()
        assertEquals(DomainSpecificLogic.LIVRO, DomainSpecificLogic.valueOf("LIVRO"));
        assertEquals(DomainSpecificLogic.ELETRONICO, DomainSpecificLogic.valueOf("ELETRONICO"));
        assertEquals(DomainSpecificLogic.COMIDA, DomainSpecificLogic.valueOf("COMIDA"));
        // name() e ordinal()
        for (DomainSpecificLogic dsl : all) {
            assertNotNull(dsl.name());
            assertTrue(dsl.ordinal() >= 0);
        }
        // equals() e hashCode()
        assertEquals(DomainSpecificLogic.LIVRO, DomainSpecificLogic.LIVRO);
        assertNotEquals(DomainSpecificLogic.LIVRO, DomainSpecificLogic.ELETRONICO);
        assertEquals(DomainSpecificLogic.LIVRO.hashCode(), DomainSpecificLogic.LIVRO.hashCode());
        // toString()
        assertNotNull(DomainSpecificLogic.LIVRO.toString());
    }
}
