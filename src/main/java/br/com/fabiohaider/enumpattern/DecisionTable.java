package br.com.fabiohaider.enumpattern;

import java.math.BigDecimal;

public enum DecisionTable {
    CLIENTE_PLATINUM {
        @Override
        public BigDecimal calculaDesconto(BigDecimal valor, boolean isPrimeiraCompra) {
            return valor.multiply(new BigDecimal("0.15"));
        }
    },
    CLIENTE_GOLD {
        @Override
        public BigDecimal calculaDesconto(BigDecimal valor, boolean isPrimeiraCompra) {
            if (isPrimeiraCompra) {
                return valor.multiply(new BigDecimal("0.10"));
            }
            return valor.multiply(new BigDecimal("0.05"));
        }
    },
    CLIENTE_SILVER {
        @Override
        public BigDecimal calculaDesconto(BigDecimal valor, boolean isPrimeiraCompra) {
            return valor.multiply(new BigDecimal("0.02"));
        }
    },
    CLIENTE_REGULAR {
        @Override
        public BigDecimal calculaDesconto(BigDecimal valor, boolean isPrimeiraCompra) {
            if (isPrimeiraCompra) {
                return valor.multiply(new BigDecimal("0.03"));
            }
            return BigDecimal.ZERO;
        }
    };

    public abstract BigDecimal calculaDesconto(BigDecimal valor, boolean isPrimeiraCompra);

    public static void main(String[] args) {
        BigDecimal valorDaCompra = new BigDecimal("200.00");

        System.out.println("Cliente Platinum (primeira compra): " + DecisionTable.CLIENTE_PLATINUM.calculaDesconto(valorDaCompra, true));
        System.out.println("Cliente Gold (primeira compra): " + DecisionTable.CLIENTE_GOLD.calculaDesconto(valorDaCompra, true));
        System.out.println("Cliente Gold (compra recorrente): " + DecisionTable.CLIENTE_GOLD.calculaDesconto(valorDaCompra, false));
        System.out.println("Cliente Regular (compra recorrente): " + DecisionTable.CLIENTE_REGULAR.calculaDesconto(valorDaCompra, false));
    }
}
