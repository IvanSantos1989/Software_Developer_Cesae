/**
 * Representa um voto de um eleitor num candidato.
 */
public class Voto {
    private Eleitor eleitor;
    private Candidato candidato;

    /**
     * Construtor do voto.
     *
     * @param eleitor Eleitor que realizou o voto
     * @param candidato Candidato escolhido
     */
    public Voto(Eleitor eleitor, Candidato candidato) {
        this.eleitor = eleitor;
        this.candidato = candidato;
    }

    /** @return Eleitor que votou */
    public Eleitor getEleitor() {
        return eleitor;
    }

    /** @return Candidato escolhido */
    public Candidato getCandidato() {
        return candidato;
    }
}
