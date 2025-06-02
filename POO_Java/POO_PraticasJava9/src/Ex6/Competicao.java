package Ex6;

public class Competicao {
    private String nome;
    private String pais;
    private Atleta[] inscritos;

    public Competicao(String nome, String pais, int maxInscritos) {
        this.nome = nome;
        this.pais = pais;
        this.inscritos = new Atleta[maxInscritos];
    }

    public void inscreverAtleta(Atleta atletaNovo) {
        for (int i = 0; i < this.inscritos.length; i++) {
            if (this.inscritos[i] == null) {
                this.inscritos[i] = atletaNovo;
                return;
            }
        }
    }

    public void listarInscritos() {
        System.out.println("\n________________________________________________________");
        for (int i = 0; i < this.inscritos.length; i++) {
            if (this.inscritos[i] != null) {
                this.inscritos[i].exibirDetalhes();
            }
        }
        System.out.println("\n________________________________________________________");
    }

    public void atletasDaCasa() {
        System.out.println("\n__________________ Atletas da Casa _____________________");
        for (int i = 0; i < this.inscritos.length; i++) {
            if (this.inscritos[i] != null) {
                if (this.inscritos[i].getPaisOrigem().equalsIgnoreCase(this.pais)) {
                    this.inscritos[i].exibirDetalhes();
                }
            }
        }
        System.out.println("\n________________________________________________________");
    }
}