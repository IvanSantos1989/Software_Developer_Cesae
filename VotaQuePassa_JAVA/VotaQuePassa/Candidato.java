/**
 * Representa um candidato numa eleição.
 */
public class Candidato {
    private String nome;
    private int idade;
    private String naturalidade;

    /**
     * Construtor do candidato.
     *
     * @param nome Nome do candidato
     * @param idade Idade do candidato
     * @param naturalidade Local de nascimento ou origem
     */
    public Candidato(String nome, int idade, String naturalidade) {
        this.nome = nome;
        this.idade = idade;
        this.naturalidade = naturalidade;
    }

    /** @return Nome do candidato */
    public String getNome() {
        return nome;
    }

    /** @return Idade do candidato */
    public int getIdade() {
        return idade;
    }

    /** @return Naturalidade do candidato */
    public String getNaturalidade() {
        return naturalidade;
    }
}
