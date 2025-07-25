package br.com.fabiohaider.enumpattern;

public enum StatusPhase {
    PENDENTE {
        @Override
        public boolean podeCancelar() {
            return true;
        }

        @Override
        public boolean podeEnviar() {
            return false;
        }

        @Override
        public String getCorExibicao() {
            return "#FFC107";
        }
    },
    PAGO {
        @Override
        public boolean podeCancelar() {
            return true;
        }

        @Override
        public boolean podeEnviar() {
            return true;
        }

        @Override
        public String getCorExibicao() {
            return "#28A745";
        }
    },
    ENVIADO {
        @Override
        public boolean podeCancelar() {
            return false;
        }

        @Override
        public boolean podeEnviar() {
            return false;
        }

        @Override
        public String getCorExibicao() {
            return "#007BFF";
        }
    },
    ENTREGUE {
        @Override
        public boolean podeCancelar() {
            return false;
        }

        @Override
        public boolean podeEnviar() {
            return false;
        }

        @Override
        public String getCorExibicao() {
            return "#6C757D";
        }
    },
    CANCELADO {
        @Override
        public boolean podeCancelar() {
            return false;
        }

        @Override
        public boolean podeEnviar() {
            return false;
        }

        @Override
        public String getCorExibicao() {
            return "#DC3545";
        }
    };

    public abstract boolean podeCancelar();

    public abstract boolean podeEnviar();

    public abstract String getCorExibicao();

    public static void main(String[] args) {
        StatusPhase statusAtual = StatusPhase.PAGO;

        System.out.println("Status atual: " + statusAtual);
        System.out.println("Pode cancelar? " + statusAtual.podeCancelar());
        System.out.println("Pode enviar? " + statusAtual.podeEnviar());
        System.out.println("Cor de exibição: " + statusAtual.getCorExibicao());

        StatusPhase deliveredStatus = StatusPhase.ENTREGUE;
        System.out.println("\nStatus de Entrega: " + deliveredStatus);
        System.out.println("Pode cancelar? " + deliveredStatus.podeCancelar());
        System.out.println("Pode enviar? " + deliveredStatus.podeEnviar());
    }
}
