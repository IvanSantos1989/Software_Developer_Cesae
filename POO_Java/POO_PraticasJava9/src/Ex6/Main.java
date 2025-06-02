package Ex6;

public class Main {
    public static void main(String[] args) {
        Competicao competicao = new Competicao("Olimpíadas", "Brasil", 5);

        Atleta atleta1 = new Atleta("João Silva", "Natação", 1.80, 75.0, "Brasil", 1);
        Atleta atleta2 = new Atleta("Maria Oliveira", "Atletismo", 1.65, 60.0, "Brasil", 2);
        Atleta atleta3 = new Atleta("Carlos Pereira", "Futebol", 1.78, 80.0, "Argentina", 3);
        Atleta atleta4 = new Atleta("Ana Costa", "Vôlei", 1.70, 70.0, "Brasil", 4);
        Atleta atleta5 = new Atleta("Pedro Santos", "Basquete", 2.00, 90.0, "EUA", 5);

        competicao.inscreverAtleta(atleta1);
        competicao.inscreverAtleta(atleta2);
        competicao.inscreverAtleta(atleta3);
        competicao.inscreverAtleta(atleta4);
        competicao.inscreverAtleta(atleta5);

        competicao.listarInscritos();
        competicao.atletasDaCasa();
    }
}