package Ex6;

public class Main {
    public static void main(String[] args) {

        Livro livro1 = new Livro("Três Porquinhos","Joaquim","Infantil",30,"123456789");
        Livro livro2 = new Livro("Harry Potter: Pedra Filosofal","J.K. Rowling","Fantasia",550,"11223344");

        livro1.exibirDetalhes();
        livro2.exibirDetalhes();
    }
}