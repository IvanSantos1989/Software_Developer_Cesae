import java.util.ArrayList;

/**
 * Representa uma eleição, com candidatos, votos e regras de idade mínima.
 */
public class Eleicao {
    private String nome;
    private int idadeMinima;
    private ArrayList<Candidato> candidatos;
    private ArrayList<Voto> votos;

    /**
     * Construtor da eleição.
     *
     * @param nome Nome da eleição
     * @param idadeMinima Idade mínima permitida para votar ou ser candidato
     */
    public Eleicao(String nome, int idadeMinima) {
        this.nome = nome;
        this.idadeMinima = idadeMinima;
        this.candidatos = new ArrayList<>();
        this.votos = new ArrayList<>();
    }

    /**
     * Adiciona um candidato à eleição, se cumprir a idade mínima.
     *
     * @param candidato Candidato a adicionar
     * @throws IllegalArgumentException Se o candidato for demasiado jovem
     */
    public void adicionarCandidato(Candidato candidato) {
        if (candidato.getIdade() <= idadeMinima) {
            throw new IllegalArgumentException("Candidato não tem idade mínima para participar.");
        }

        if (contemCandidato(candidato)) {
            candidatos.add(candidato);
        }
    }

    /**
     * Regista um voto na eleição.
     *
     * @param eleitor Eleitor que vota
     * @param candidato Candidato escolhido
     * @throws IllegalArgumentException Se o eleitor for menor, já tiver votado ou o candidato não existir
     */
    public void votar(Eleitor eleitor, Candidato candidato) {
        if (eleitor.getIdade() <= idadeMinima) {
            throw new IllegalArgumentException("Eleitor não tem idade mínima para votar.");
        }

        if (!contemCandidato(candidato)) {
            throw new IllegalArgumentException("Candidato não encontrado.");
        }

        if (eleitorJaVotou(eleitor)) {
            throw new IllegalArgumentException("Este eleitor já votou.");
        }

        votos.add(new Voto(eleitor, candidato));
    }

    /**
     * Conta os votos recebidos por um determinado candidato.
     *
     * @param candidato Candidato alvo
     * @return Número total de votos
     */
    public int contarVotos(Candidato candidato) {
        int total = 0;
        for (Voto voto : votos) {
            if (voto.getCandidato() == candidato) {
                total++;
            }
        }
        return total;
    }

    /**
     * Obtém o candidato vencedor da eleição.
     *
     * @return Candidato com mais votos ou {@code null} em caso de empate
     */
    public Candidato obterVencedor() {
        Candidato vencedor = null;
        int maxVotos = -1;
        boolean empate = false;

        for (Candidato c : candidatos) {
            int votosCandidato = contarVotos(c);

            if (votosCandidato > maxVotos) {
                maxVotos = votosCandidato;
                vencedor = c;
                empate = false;
            } else if (votosCandidato == maxVotos && maxVotos >= 0) {
                empate = true;
            }
        }

        return empate ? null : vencedor;
    }

    // ========================
    // Métodos auxiliares
    // ========================

    private boolean eleitorJaVotou(Eleitor eleitor) {
        for (Voto voto : votos) {
            if (voto.getEleitor().getNome() == eleitor.getNome()) {
                return true;
            }
        }
        return false;
    }

    private boolean contemCandidato(Candidato candidato) {
        for (Candidato c : candidatos) {
            if (c == candidato) {
                return true;
            }
        }
        return false;
    }

    /** @return Nome da eleição */
    public String getNome() {
        return nome;
    }

    /** @return Idade mínima exigida */
    public int getIdadeMinima() {
        return idadeMinima;
    }

    /** @return Lista de candidatos inscritos */
    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    /** @return Lista de votos registados */
    public ArrayList<Voto> getVotos() {
        return votos;
    }
}
