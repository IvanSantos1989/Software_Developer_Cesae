package Ex2;

public class Main {
    public static void main(String[] args) {

        ContaBancaria c1 = new ContaBancaria("PT50 123", "Ivan");
        ContaBancaria c2 = new ContaBancaria("PT50 555", "Quim");
        ContaBancaria c3 = new ContaBancaria("PT50 111", "Joana");

        System.out.println("_______________________________________");
        c1.exibirDetalhes();
        c2.exibirDetalhes();
        c3.exibirDetalhes();
        System.out.println("_______________________________________");

        // Fazer 3 depósitovs
        c1.depositar(500);
        c2.depositar(10);
        c3.depositar(2000);

        System.out.println("_______________________________________");
        c1.exibirDetalhes();
        c2.exibirDetalhes();
        c3.exibirDetalhes();
        System.out.println("_______________________________________");

        // Testar os levantamentos
        c1.levantar(200);
        c2.levantar(1000);
        c3.levantar(50);

        System.out.println("_______________________________________");
        c1.exibirDetalhes();
        c2.exibirDetalhes();
        c3.exibirDetalhes();
        System.out.println("_______________________________________");


        c1.transferencia(c2,50);


        System.out.println("_______________________________________");
        c1.exibirDetalhes();
        c2.exibirDetalhes();
        c3.exibirDetalhes();
        System.out.println("_______________________________________");


        c2.transferencia(c3,2000);


        System.out.println("_______________________________________");
        c1.exibirDetalhes();
        c2.exibirDetalhes();
        c3.exibirDetalhes();
        System.out.println("_______________________________________");

    }
}