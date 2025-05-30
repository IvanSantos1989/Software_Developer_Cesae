package Ex9;

/**
 * Classe Funcionário - Representa um funcionário com nome, email, departamento e salário.
 */
public class Funcionario {
    private String nome;
    private String email;
    private String departamento;
    private double salario;

    /**
     * Construtor da classe <b>Funcionario</b>
     * @param nome Nome do funcionário
     * @param email Email do funcionário
     * @param departamento Departamento onde o funcionário trabalha
     * @param salario Salário atual do funcionário (€)
     */
    public Funcionario(String nome, String email, String departamento, double salario) {
        this.nome = nome;
        this.email = email;
        this.departamento = departamento;
        this.salario = salario;
    }

    // Métodos de acesso (getters)
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Aumenta o salário de acordo com uma percentagem recebida
     * @param percentagem Percentagem de aumento (ex: 15 representa 15%)
     */
    public void aumentarSalario(double percentagem) {
        this.salario += this.salario * percentagem / 100;
    }

    /**
     * Exibe os dados completos do funcionário
     */
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Departamento: " + departamento);
        System.out.println("Salário: " + salario + "€");
    }
}