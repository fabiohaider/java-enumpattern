package br.com.fabiohaider.enumpattern;

public enum Singleton {
    INSTANCIA;

    public void executarAcao() {
        System.out.println("A instância Singleton está fazendo algo.");
    }

    public static void main(String[] args) {
        Singleton.INSTANCIA.executarAcao();
        Singleton novaInstancia = Singleton.INSTANCIA;
        System.out.println(Singleton.INSTANCIA == novaInstancia);
    }
}
