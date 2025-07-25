package br.com.fabiohaider.enumpattern;

import java.util.function.Predicate;

public enum ConfigurableValidators {
    IS_NUMERO(input -> input != null && input.matches("\\d+")),
    IS_EMAIL(input -> input != null && input.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")),
    IS_NAO_VAZIO(input -> input != null && !input.trim().isEmpty());

    private final Predicate<String> funcaoDeValidacao;

    ConfigurableValidators(Predicate<String> funcaoDeValidacao) {
        this.funcaoDeValidacao = funcaoDeValidacao;
    }

    public boolean validar(String entrada) {
        return funcaoDeValidacao.test(entrada);
    }

    public static void main(String[] args) {
        String testeEntrada = "user@example.com";
        boolean isEmailValido = ConfigurableValidators.IS_EMAIL.validar(testeEntrada);
        System.out.println("e-Mail é Válido ? " + isEmailValido);

        System.out.println("Teste Null: " + ConfigurableValidators.IS_NAO_VAZIO.validar(null));
    }
}