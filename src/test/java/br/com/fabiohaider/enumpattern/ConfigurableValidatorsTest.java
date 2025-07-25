package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConfigurableValidatorsTest {
    @Test
    void testIsNumero() {
        assertTrue(ConfigurableValidators.IS_NUMERO.validar("12345"));
        assertFalse(ConfigurableValidators.IS_NUMERO.validar("12a45"));
        assertFalse(ConfigurableValidators.IS_NUMERO.validar(""));
        assertFalse(ConfigurableValidators.IS_NUMERO.validar(null));
    }

    @Test
    void testIsEmail() {
        assertTrue(ConfigurableValidators.IS_EMAIL.validar("user@example.com"));
        assertTrue(ConfigurableValidators.IS_EMAIL.validar("a.b-c@d.com"));
        assertFalse(ConfigurableValidators.IS_EMAIL.validar("userexample.com"));
        assertFalse(ConfigurableValidators.IS_EMAIL.validar("@example.com"));
        assertFalse(ConfigurableValidators.IS_EMAIL.validar(null));
    }

    @Test
    void testIsNaoVazio() {
        assertTrue(ConfigurableValidators.IS_NAO_VAZIO.validar("abc"));
        assertFalse(ConfigurableValidators.IS_NAO_VAZIO.validar("   "));
        assertFalse(ConfigurableValidators.IS_NAO_VAZIO.validar(""));
        assertFalse(ConfigurableValidators.IS_NAO_VAZIO.validar(null));
    }
}
