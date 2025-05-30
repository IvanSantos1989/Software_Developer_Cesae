package Ex1;

public class Main {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("Vitor", 25, 1.7,300050);
        Pessoa pessoa2 = new Pessoa("Joaquim", 40, 1.8,400005);
        Pessoa pessoa3 = new Pessoa("José", 30, 1.65,9903334);

        System.out.println(pessoa1.getNome());
        System.out.println(pessoa1.getIdade());
        System.out.println(pessoa1.getAltura());

    }
}