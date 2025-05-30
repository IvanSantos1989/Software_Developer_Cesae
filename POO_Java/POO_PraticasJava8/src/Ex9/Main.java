package Ex9;

public class Main {
    public static void main(String[] args) {

//No main:
//a) Instâncie um funcionário, definindo os seus atributos usando o construtor.
//b) Exiba todos os dados do funcionário.
//c) Aumente o salário.
//d) Exiba novamente os dados do funcionário.

        Funcionario funcionario = new Funcionario("João Silva", "ivan@gmail.pt", "TI", 2500.00);

        funcionario.exibirDados(); // Exibe os dados do funcionário
        funcionario.aumentarSalario(10); // Aumenta o salário em 10%
        System.out.println("Após aumento de salário:" + funcionario.getSalario() + "€");
    }
}