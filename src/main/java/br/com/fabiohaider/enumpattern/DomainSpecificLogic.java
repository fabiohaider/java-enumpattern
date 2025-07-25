package br.com.fabiohaider.enumpattern;

import java.math.BigDecimal;
import java.util.Arrays;

public enum DomainSpecificLogic {
    LIVRO {
        @Override
        public BigDecimal calculaTaxa(BigDecimal valor) {
            return valor.multiply(new BigDecimal("0.05"));
        }

        @Override
        public String getDescricao() {
            return "Item de leitura e conhecimento";
        }
    },
    ELETRONICO {
        @Override
        public BigDecimal calculaTaxa(BigDecimal valor) {
            return valor.multiply(new BigDecimal("0.18"));
        }

        @Override
        public String getDescricao() {
            return "Dispositivo eletrônico";
        }
    },
    COMIDA {
        @Override
        public BigDecimal calculaTaxa(BigDecimal valor) {
            return BigDecimal.ZERO;
        }

        @Override
        public String getDescricao() {
            return "Produto alimentício";
        }
    };

    public abstract BigDecimal calculaTaxa(BigDecimal valor);

    public abstract String getDescricao();

    public static void main(String[] args) {
        var valores = new BigDecimal[]{BigDecimal.valueOf(50), BigDecimal.valueOf(1200), BigDecimal.valueOf(10)};
        var tipos = values();

        System.out.println("--- Preços Específicos ---");
        Arrays.stream(tipos)
                .forEach(type -> System.out.printf("%s Taxa: %.2f, Descrição: %s%n",
                        type, type.calculaTaxa(valores[type.ordinal()]), type.getDescricao()));

        System.out.println("\n--- Todos os Tipos de Produto com Preço de Exemplo (100) ---");
        var samplePrice = BigDecimal.valueOf(100);
        Arrays.stream(tipos)
                .map(type -> "Tipo: %s, Taxa: %.2f, Descrição: %s"
                        .formatted(type.name(), type.calculaTaxa(samplePrice), type.getDescricao()))
                .forEach(System.out::println);
    }
}
