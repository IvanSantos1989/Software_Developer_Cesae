package Ex8;

public class Main {
    public static void main(String[] args) {

    Produto produto1 = new Produto("Batata", 0.5);
    Produto produto2 = new Produto("Vinho Verde", 1);
    System.out.println("_____________________________________________");
    produto1.exibirDetalhes();
    produto2.exibirDetalhes();
    System.out.println("_____________________________________________");

    produto1.adquirirStock(10);
    produto2.adquirirStock(50);

    System.out.println("_____________________________________________");
    produto1.exibirDetalhes();
    produto2.exibirDetalhes();
    System.out.println("_____________________________________________");

    produto1.adquirirStock(2);
    produto2.adquirirStock(5);

    System.out.println("_____________________________________________");
    produto1.exibirDetalhes();
    produto2.exibirDetalhes();
    System.out.println("_____________________________________________");

    produto1.venderStock(90);
    produto2.venderStock(15);

    System.out.println("_____________________________________________");
    produto1.exibirDetalhes();
    produto2.exibirDetalhes();
    System.out.println("_____________________________________________");
}
}