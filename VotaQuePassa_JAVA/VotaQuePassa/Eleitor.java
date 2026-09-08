/**
 * Representa um eleitor com dados pessoais.
 */
public class Eleitor {
    private String nome;
    private String numeroIdentificacao;
    private int idade;
    private String email;
    private String telemovel;

    /**
     * Construtor do eleitor.
     *
     * @param nome Nome completo do eleitor
     * @param numeroIdentificacao Número de identificação único
     * @param idade Idade do eleitor
     * @param email Email de contacto
     * @param telemovel Número de telemóvel
     */
    public Eleitor(String nome, String numeroIdentificacao, int idade, String email, String telemovel) {
        this.nome = nome;
        this.numeroIdentificacao = numeroIdentificacao;
        this.idade = idade;
        this.email = email;
        this.telemovel = telemovel;
    }

    /** @return Nome do eleitor */
    public String getNome() {
        return nome;
    }

    /** @return Número de identificação do eleitor */
    public String getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    /** @return Idade do eleitor */
    public int getIdade() {
        return idade;
    }

    /** @return Email do eleitor */
    public String getEmail() {
        return email;
    }

    /** @return Telemóvel do eleitor */
    public String getTelemovel() {
        return telemovel;
    }
}
