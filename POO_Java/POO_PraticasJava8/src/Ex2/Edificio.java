package Ex2;

public class Edificio {
    private String nome;
    private String rua;
    private String cidade;
    private String corFachada;
    private int numeroAndares;
    private boolean temGaragem;


    public Edificio(String nome, String rua,
                    String cidade, String corFachada,
                    int numeroAndares, boolean temGaragem) {
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
        this.corFachada = corFachada;
        this.numeroAndares = numeroAndares;
        this.temGaragem = temGaragem;
    }

    public String getNome() {
        return nome;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCorFachada() {
        return corFachada;
    }

    public int getNumeroAndares() {
        return numeroAndares;
    }

    public boolean gettemGaragem() {
        return temGaragem;
    }

    public void setCorFachada (String corFachada) {
        this.corFachada = corFachada;
    }
}