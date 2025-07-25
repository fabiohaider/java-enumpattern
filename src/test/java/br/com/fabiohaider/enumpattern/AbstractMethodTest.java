package br.com.fabiohaider.enumpattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static br.com.fabiohaider.enumpattern.AbstractMethod.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractMethodTest {

    @ParameterizedTest
    @DisplayName("Teste das operações básicas")
    @MethodSource("operacoesValidasProvider")
    void testOperacoesBasicas(AbstractMethod operacao, double x, double y, double esperado) {
        assertEquals(esperado, operacao.aplicar(x, y), 0.0001,
                () -> "Erro na operação " + operacao + " com valores " + x + " e " + y);
    }

    private static Stream<Arguments> operacoesValidasProvider() {
        return Stream.of(
                Arguments.of(ADICAO, 10.0, 5.0, 15.0),
                Arguments.of(SUBTRACAO, 10.0, 5.0, 5.0),
                Arguments.of(MULTIPLICACAO, 10.0, 5.0, 50.0),
                Arguments.of(DIVISAO, 10.0, 5.0, 2.0),
                Arguments.of(ADICAO, -3.5, 2.5, -1.0),
                Arguments.of(DIVISAO, 1.0, 3.0, 0.3333333)
        );
    }

    @Test
    @DisplayName("Divisão por zero deve lançar exceção com mensagem correta")
    void testDivisaoPorZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> DIVISAO.aplicar(10.0, 0.0)
        );
        assertEquals("Não pode dividir por Zero", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Teste de valores extremos (limites)")
    @MethodSource("casosExtremosProvider")
    void testCasosExtremos(AbstractMethod operacao, double x, double y, double esperado) {
        if (operacao == DIVISAO && y == 0.0) {
            assertThrows(IllegalArgumentException.class, () -> operacao.aplicar(x, y));
        } else {
            assertEquals(esperado, operacao.aplicar(x, y), 0.0001);
        }
    }

    private static Stream<Arguments> casosExtremosProvider() {
        double max = Double.MAX_VALUE;
        double min = Double.MIN_VALUE;

        return Stream.of(
                Arguments.of(ADICAO, 0.0, 0.0, 0.0),
                Arguments.of(ADICAO, max, 1.0, max),
                Arguments.of(ADICAO, min, 1.0, min + 1),
                Arguments.of(SUBTRACAO, max, max, 0.0),
                Arguments.of(MULTIPLICACAO, max, 2.0, Double.POSITIVE_INFINITY),
                Arguments.of(DIVISAO, max, 2.0, max / 2),
                Arguments.of(DIVISAO, 1.0, 0.0, 0.0) // Deve lançar exceção
        );
    }

    @Test
    @DisplayName("Valida quantidade e ordem dos valores do enum")
    void testValoresEnum() {
        AbstractMethod[] values = AbstractMethod.values();
        assertEquals(4, values.length);
        assertArrayEquals(new AbstractMethod[]{ADICAO, SUBTRACAO, MULTIPLICACAO, DIVISAO}, values);
    }
}
