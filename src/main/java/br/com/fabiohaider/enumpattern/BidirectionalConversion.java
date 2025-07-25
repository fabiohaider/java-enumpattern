package br.com.fabiohaider.enumpattern;

import java.util.Arrays;
import java.util.Optional;

public enum BidirectionalConversion {
    PENDENTE("P"),
    PROCESSANDO("PR"),
    ENVIADO("S"),
    ENTREGUE("D"),
    CANCELADO("C");

    private final String codigo;

    BidirectionalConversion(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static Optional<BidirectionalConversion> aPartirDoCodigo(String codigo) {
        return Arrays.stream(BidirectionalConversion.values())
                .filter(status -> status.codigo.equalsIgnoreCase(codigo))
                .findFirst();
    }

    public static void main(String[] args) {
        System.out.println("Código PENDENTE: " + BidirectionalConversion.PENDENTE.getCodigo());
        System.out.println("Código ENTREGUE: " + BidirectionalConversion.ENTREGUE.getCodigo());

        BidirectionalConversion status1 = BidirectionalConversion.aPartirDoCodigo("S").orElse(null);
        System.out.println("Status de 'S': " + status1);

        BidirectionalConversion status2 = BidirectionalConversion.aPartirDoCodigo("XYZ").orElse(null);
        System.out.println("Status de 'XYZ': " + status2); // Deve ser null

        BidirectionalConversion.aPartirDoCodigo("D").ifPresent(s -> System.out.println("Status encontrado: " + s));
    }
}
