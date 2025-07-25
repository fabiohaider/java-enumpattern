package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PropertyMappingTest {
    @Test
    void testEntradaInvalida() {
        assertEquals("E001", PropertyMapping.ENTRADA_INVALIDA.getCodigo());
        assertEquals("Entrada fornecida é inválida", PropertyMapping.ENTRADA_INVALIDA.getMensagem());
        assertEquals(PropertyMapping.Severidade.ERRO, PropertyMapping.ENTRADA_INVALIDA.getSeveridade());
    }

    @Test
    void testAcessoNaoAutorizado() {
        assertEquals("E002", PropertyMapping.ACESSO_NAO_AUTORIZADO.getCodigo());
        assertEquals("O usuário não tem permissão", PropertyMapping.ACESSO_NAO_AUTORIZADO.getMensagem());
        assertEquals(PropertyMapping.Severidade.CRITICO, PropertyMapping.ACESSO_NAO_AUTORIZADO.getSeveridade());
    }

    @Test
    void testServicoIndisponivel() {
        assertEquals("E003", PropertyMapping.SERVIÇO_INDISPONIVEL.getCodigo());
        assertEquals("O serviço externo não está respondendo", PropertyMapping.SERVIÇO_INDISPONIVEL.getMensagem());
        assertEquals(PropertyMapping.Severidade.AVISO, PropertyMapping.SERVIÇO_INDISPONIVEL.getSeveridade());
    }
}
