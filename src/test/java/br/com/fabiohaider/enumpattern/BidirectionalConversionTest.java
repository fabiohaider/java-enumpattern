package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BidirectionalConversionTest {

    @Test
    void testGetCodigo() {
        assertEquals("P", BidirectionalConversion.PENDENTE.getCodigo());
        assertEquals("PR", BidirectionalConversion.PROCESSANDO.getCodigo());
        assertEquals("S", BidirectionalConversion.ENVIADO.getCodigo());
        assertEquals("D", BidirectionalConversion.ENTREGUE.getCodigo());
        assertEquals("C", BidirectionalConversion.CANCELADO.getCodigo());
    }

    @Test
    void testAPartirDoCodigoValido() {
        assertEquals(Optional.of(BidirectionalConversion.PENDENTE), BidirectionalConversion.aPartirDoCodigo("P"));
        assertEquals(Optional.of(BidirectionalConversion.PROCESSANDO), BidirectionalConversion.aPartirDoCodigo("PR"));
        assertEquals(Optional.of(BidirectionalConversion.ENVIADO), BidirectionalConversion.aPartirDoCodigo("S"));
        assertEquals(Optional.of(BidirectionalConversion.ENTREGUE), BidirectionalConversion.aPartirDoCodigo("D"));
        assertEquals(Optional.of(BidirectionalConversion.CANCELADO), BidirectionalConversion.aPartirDoCodigo("C"));
    }

    @Test
    void testAPartirDoCodigoCaseInsensitive() {
        assertEquals(Optional.of(BidirectionalConversion.PENDENTE), BidirectionalConversion.aPartirDoCodigo("p"));
        assertEquals(Optional.of(BidirectionalConversion.PROCESSANDO), BidirectionalConversion.aPartirDoCodigo("pr"));
    }

    @Test
    void testAPartirDoCodigoInvalido() {
        assertEquals(Optional.empty(), BidirectionalConversion.aPartirDoCodigo("XYZ"));
        assertEquals(Optional.empty(), BidirectionalConversion.aPartirDoCodigo(""));
        assertEquals(Optional.empty(), BidirectionalConversion.aPartirDoCodigo(null));
    }
}
