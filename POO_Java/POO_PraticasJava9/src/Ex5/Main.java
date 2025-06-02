package Ex5;

public class Main {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("Joaquim",30,"Porto","quim@mail.pt",911222333);
        Pessoa pessoa2 = new Pessoa("Joana",28,"Algarve","joana@mail.pt",922333444);
        Pessoa pessoa3 = new Pessoa("José",40,"Porto","ze@mail.pt",933111222);
        Pessoa pessoa4 = new Pessoa("Sofia",18,"Lisboa","sofia@mail.pt",911888999);

        Agenda aMinhaAgenda = new Agenda(20);
        aMinhaAgenda.adicionarContacto(pessoa1);
        aMinhaAgenda.adicionarContacto(pessoa2);
        aMinhaAgenda.adicionarContacto(pessoa3);
        aMinhaAgenda.adicionarContacto(pessoa4);

        aMinhaAgenda.listarContactos();

        aMinhaAgenda.pesquisarCidade("Porto");

        aMinhaAgenda.pesquisarCidade("Lisboa");
    }
}