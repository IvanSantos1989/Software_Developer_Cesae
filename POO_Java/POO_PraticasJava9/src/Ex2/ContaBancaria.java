package Ex2;

public class ContaBancaria {
    private String iban;
    private String titular;
    private double saldo = 0;
    private int anoAbertura = 2025;
    private double margemEmprestimo = 0.5;
    private double valorDividia = 0;

    /**
     * Método construtor para <b>Conta Bancária</b>
     *
     * @param iban    IBAN - Identificador da <b>Conta Bancária</b>
     * @param titular Nome do Titular
     */
    public ContaBancaria(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
    }

    /**
     * Método para depositar dinheiro
     *
     * @param valor Valor a depositar (€)
     */
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println(valor + " € depositados na conta " + this.iban);
    }

    /**
     * Método para levantar dinheiro
     *
     * @param valor Valor a levantar (€)
     */
    public void levantar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println(valor + " € levantados da conta " + this.iban);
        } else {
            System.out.println("Saldo insuficiente na conta " + this.iban + ". Levantamento de " + valor + " € recusado.");
        }
    }

    /**
     * Método que permite transferir dinheiro de uma Conta para a outra
     *
     * @param contaDestino Conta que vai receber o dinheiro
     * @param valor        Valor a transferir (€)
     */
    public void transferencia(ContaBancaria contaDestino, double valor) {
        if (this.saldo >= valor) { // Transferência válida
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println(valor + " € transferidos de " + this.iban + " para " + contaDestino.iban);
        } else { // Transferência inválida
            System.out.println("Saldo insuficiente na conta " + this.iban + ". Transferência de " + valor + " € para " + contaDestino.iban + " recusada.");
        }
    }

    public void pedirEmprestimo(double valorPedir) {

        double valorMaxEmprestimo = this.saldo * this.margemEmprestimo;

        if (valorPedir > valorMaxEmprestimo) {
            System.out.println("Empréstimo recusado. Valor máximo de empréstimo excedido.");
        } else if (this.valorDividia > 0) {
            System.out.println("Empréstimo recusado. Salde a dívida existente primeiro.");
        } else {
            System.out.println("Empréstimo concedido. Pode encontrar o valor no seu saldo bancário.");
            this.saldo += valorPedir;
            this.valorDividia += valorPedir;
        }
    }

    public void amortizarEmprestimo(double valorAmortizar) {

        if (this.saldo < valorAmortizar) {
            System.out.println("Operação recusada. Saldo insuficiente.");
        } else if (valorAmortizar > this.valorDividia) {
            System.out.println("Operação recusada. A sua dívida é inferior ao valor que está a pretender amortizar.");
        } else {
            this.saldo -= valorAmortizar;
            this.valorDividia -= valorAmortizar;
            System.out.println("Valor amortizado com sucesso. Dívida restante: " + this.valorDividia);
        }
    }

    /**
     * Método para exibir os detalhes de uma Conta
     */
    public void exibirDetalhes() {
        System.out.println(this.iban + " | " + this.titular + " | Saldo: " + this.saldo + " €");
    }
}