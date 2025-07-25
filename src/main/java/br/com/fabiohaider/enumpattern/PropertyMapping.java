package br.com.fabiohaider.enumpattern;

import java.util.Arrays;

public enum PropertyMapping {
    ENTRADA_INVALIDA("E001", "Entrada fornecida é inválida", Severidade.ERRO),
    ACESSO_NAO_AUTORIZADO("E002", "O usuário não tem permissão", Severidade.CRITICO),
    SERVIÇO_INDISPONIVEL("E003", "O serviço externo não está respondendo", Severidade.AVISO);

    private final String codigo;
    private final String mensagem;
    private final Severidade severidade;

    PropertyMapping(String codigo, String mensagem, Severidade severidade) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.severidade = severidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Severidade getSeveridade() {
        return severidade;
    }

    public enum Severidade {
        INFO, AVISO, ERRO, CRITICO
    }

    public static void main(String[] args) {
        var erro = ACESSO_NAO_AUTORIZADO;

        System.out.println("Erro Individual: " + erro);

        System.out.println("\nTodos os Erros:");
        Arrays.stream(values())
                .map(PropertyMapping::toString)
                .forEach(System.out::println);
    }
}
