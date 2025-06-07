package Ex2;

public class Main {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("Vitor", 25, 911222333, "vitor@mail.pt");
        Pessoa pessoa2 = new Pessoa("Joana", 15, 922333444, "joana@mail.pt");
        Pessoa pessoa3 = new Pessoa("Quim", 40, 911333999, "quim@mail.pt");
        Pessoa pessoa4 = new Pessoa("Zé", 20, 922111888, "ze@mail.pt");
        Pessoa pessoa5 = new Pessoa("Mariana", 30, 922444333, "mariana@mail.pt");

        Sorteio meuSorteio = new Sorteio("Euromilhoes", 10000);
        meuSorteio.inscreverParticipante(pessoa1);
        meuSorteio.inscreverParticipante(pessoa2);
        meuSorteio.inscreverParticipante(pessoa3);
        meuSorteio.inscreverParticipante(pessoa4);
        meuSorteio.inscreverParticipante(pessoa5);

        meuSorteio.listarParticipantes();

        System.out.println("\n*_*_*_*_*_*_*_*_*_* Vencedor *_*_*_*_*_*_*_*_*_*");
        Pessoa vencedor = meuSorteio.sortearVencedor();
        vencedor.exibirDetalhes();
    }
}