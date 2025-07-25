package br.com.fabiohaider.enumpattern;

import java.util.function.Supplier;

abstract class Forma {
    public abstract void desenha();
}

class Circulo extends Forma {
    @Override
    public void desenha() {
        System.out.println("Desenhando um Círculo");
    }
}

class Quadrado extends Forma {
    @Override
    public void desenha() {
        System.out.println("Desenhando um Quadrado");
    }
}

class Triagulo extends Forma {
    @Override
    public void desenha() {
        System.out.println("Desenhando um Triangulo");
    }
}

public enum Factory {
    CIRCULO(Circulo::new),
    QUADRADO(Quadrado::new),
    TRIANGULO(Triagulo::new);

    private final Supplier<Forma> provedorDeForma;

    Factory(Supplier<Forma> provedorDeForma) {
        this.provedorDeForma = provedorDeForma;
    }

    public Forma criar() {
        return provedorDeForma.get();
    }

    public static void main(String[] args) {
        Forma forma = Factory.QUADRADO.criar();
        forma.desenha();
    }
}