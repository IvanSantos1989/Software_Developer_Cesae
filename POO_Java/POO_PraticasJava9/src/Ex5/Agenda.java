package Ex5;

public class Agenda {
    private int anoCriacao = 2025;
    private Pessoa[] listaContactos;

    public Agenda(int tamanhoLista) {
        this.listaContactos = new Pessoa[tamanhoLista];
    }

    public void adicionarContacto(Pessoa contactoNovo) {

        for (int i = 0; i < this.listaContactos.length; i++) {
            if (this.listaContactos[i] == null) {
                // Encontramos uma posição vazia

                // Preenchemos a posição vazia com o novo contacto
                this.listaContactos[i] = contactoNovo;

                // Terminamos o método
                // Vamos evitar preencher todas as posições que estão vazias com a mesma Pessoa
                return;
            }
        }

    }

    public void listarContactos() {
        System.out.println("\n________________________________________________________");
        for (int i = 0; i < this.listaContactos.length; i++) {

            // Esta verificação permite perceber se temos uma Pessoa na posição atual do array
            // Se a posição estiver vazia (null), não podemos invocar os métodos (como o exibirDetalhes)
            if (this.listaContactos[i] != null) {
                this.listaContactos[i].exibirDetalhes();
            }
        }
        System.out.println("________________________________________________________");
    }

    public void pesquisarCidade(String cidadePesquisar) {

        System.out.println("\n________________ Contactos de " + cidadePesquisar + " ________________");

        for (int i = 0; i < this.listaContactos.length; i++) {

            if(this.listaContactos[i]!=null){ // Perceber se a posição atual está preenchida

                // Perceber se a cidade da pessoa atual é igual à cidade que queremos pesquisar
                if (this.listaContactos[i].getCidade().equalsIgnoreCase(cidadePesquisar)) {
                    // Se a cidade bater certo, imprimos os detalhes da pessoa
                    this.listaContactos[i].exibirDetalhes();
                }

            }

        }

        System.out.println("________________________________________________________");

    }
}