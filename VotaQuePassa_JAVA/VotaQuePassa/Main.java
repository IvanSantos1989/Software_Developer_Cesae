public class Main {
    public static void main(String[] args) {
        // Criar eleições
        Eleicao eleicaoAutarquica = new Eleicao("Eleicoes Autarquicas 2025", 18);
        Eleicao eleicaoAssociacaoEstudantes = new Eleicao("Associacao de Estudantes - Secundaria Freixo de Espada a Cinta", 14);

        // Candidatos para a eleição autárquica
        Candidato aut1 = new Candidato("Joana Almeida", 42, "Trofa");
        Candidato aut2 = new Candidato("Ricardo Meireles", 50, "Maia");
        Candidato aut3 = new Candidato("Cristiano Ronaldo", 38, "Porto");
        Candidato aut4 = new Candidato("Joaquim Alberto", 45, "Gaia");

        // Candidatos para a associação de estudantes
        Candidato ass1 = new Candidato("Mariana Costa", 17, "Trofa");
        Candidato ass2 = new Candidato("Luis Pereira", 16, "Trofa");
        Candidato ass3 = new Candidato("Sofia Matos", 18, "Santo Tirso");
        Candidato ass4 = new Candidato("Bruno Gomes", 15, "Maia");

        // Adicionar candidatos às eleições
        eleicaoAutarquica.adicionarCandidato(aut1);
        eleicaoAutarquica.adicionarCandidato(aut2);
        eleicaoAutarquica.adicionarCandidato(aut3);
        eleicaoAutarquica.adicionarCandidato(aut4);

        eleicaoAssociacaoEstudantes.adicionarCandidato(ass1);
        eleicaoAssociacaoEstudantes.adicionarCandidato(ass2);
        eleicaoAssociacaoEstudantes.adicionarCandidato(ass3);
        eleicaoAssociacaoEstudantes.adicionarCandidato(ass4);

        // Criar 20 eleitores manualmente
        Eleitor[] eleitores = {
                new Eleitor("Ana Rocha", "E001", 17, "ana@mail.com", "911000001"),
                new Eleitor("João Santos", "E002", 20, "joao@mail.com", "911000002"),
                new Eleitor("Carla Mendes", "E003", 15, "carla@mail.com", "911000003"),
                new Eleitor("Tiago Lopes", "E004", 18, "tiago@mail.com", "911000004"),
                new Eleitor("Rita Faria", "E005", 16, "rita@mail.com", "911000005"),
                new Eleitor("Miguel Almeida", "E006", 14, "miguel@mail.com", "911000006"),
                new Eleitor("Inês Pires", "E007", 22, "ines@mail.com", "911000007"),
                new Eleitor("Bruno Carvalho", "E008", 19, "bruno@mail.com", "911000008"),
                new Eleitor("Filipa Sousa", "E009", 17, "filipa@mail.com", "911000009"),
                new Eleitor("Pedro Costa", "E010", 21, "pedro@mail.com", "911000010"),
                new Eleitor("Joana Ribeiro", "E011", 18, "joana@mail.com", "911000011"),
                new Eleitor("André Moreira", "E012", 15, "andre@mail.com", "911000012"),
                new Eleitor("Lara Fernandes", "E013", 16, "lara@mail.com", "911000013"),
                new Eleitor("Diogo Silva", "E014", 20, "diogo@mail.com", "911000014"),
                new Eleitor("Marta Tavares", "E015", 19, "marta@mail.com", "911000015"),
                new Eleitor("Gonçalo Pinto", "E016", 14, "goncalo@mail.com", "911000016"),
                new Eleitor("Vera Matos", "E017", 15, "vera@mail.com", "911000017"),
                new Eleitor("Rui Teixeira", "E018", 17, "rui@mail.com", "911000018"),
                new Eleitor("Cátia Lima", "E019", 18, "catia@mail.com", "911000019"),
                new Eleitor("Fernando Simões", "E020", 23, "fernando@mail.com", "911000020")
        };

        // Votação na eleição autárquica (apenas maiores de idade)
        votar(eleicaoAutarquica, eleitores[1], aut3);
        votar(eleicaoAutarquica, eleitores[3], aut2);
        votar(eleicaoAutarquica, eleitores[7], aut1);
        votar(eleicaoAutarquica, eleitores[9], aut4);
        votar(eleicaoAutarquica, eleitores[10], aut3);
        votar(eleicaoAutarquica, eleitores[13], aut2);
        votar(eleicaoAutarquica, eleitores[14], aut3);
        votar(eleicaoAutarquica, eleitores[18], aut1);
        votar(eleicaoAutarquica, eleitores[19], aut4);

        // Votação na associação de estudantes (idade mínima 14)
        votar(eleicaoAssociacaoEstudantes, eleitores[0], ass2);
        votar(eleicaoAssociacaoEstudantes, eleitores[2], ass1);
        votar(eleicaoAssociacaoEstudantes, eleitores[4], ass1);
        votar(eleicaoAssociacaoEstudantes, eleitores[5], ass3);
        votar(eleicaoAssociacaoEstudantes, eleitores[8], ass3);
        votar(eleicaoAssociacaoEstudantes, eleitores[11], ass4);
        votar(eleicaoAssociacaoEstudantes, eleitores[12], ass2);
        votar(eleicaoAssociacaoEstudantes, eleitores[15], ass4);
        votar(eleicaoAssociacaoEstudantes, eleitores[16], ass1);
        votar(eleicaoAssociacaoEstudantes, eleitores[17], ass2);

        // Resultados
        System.out.println("\n=== Resultados - " + eleicaoAutarquica.getNome() + " ===");
        for (Candidato c : eleicaoAutarquica.getCandidatos()) {
            System.out.println(c.getNome() + ": " + eleicaoAutarquica.contarVotos(c) + " votos");
        }
        Candidato vencedorAut = eleicaoAutarquica.obterVencedor();
        System.out.println("Vencedor: " + (vencedorAut != null ? vencedorAut.getNome() : "Empate"));

        System.out.println("\n=== Resultados - " + eleicaoAssociacaoEstudantes.getNome() + " ===");
        for (Candidato c : eleicaoAssociacaoEstudantes.getCandidatos()) {
            System.out.println(c.getNome() + ": " + eleicaoAssociacaoEstudantes.contarVotos(c) + " votos");
        }
        Candidato vencedorAss = eleicaoAssociacaoEstudantes.obterVencedor();
        System.out.println("Vencedor: " + (vencedorAss != null ? vencedorAss.getNome() : "Empate"));
    }

    // Método auxiliar de votação com tratamento de exceções
    private static void votar(Eleicao eleicao, Eleitor eleitor, Candidato candidato) {
        try {
            eleicao.votar(eleitor, candidato);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao votar: " + e.getMessage() + " (" + eleitor.getNome() + ")");
        }
    }
}
