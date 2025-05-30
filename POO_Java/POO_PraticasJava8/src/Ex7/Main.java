package Ex7;

public class Main {
    public static void main(String[] args) {

        Aluno aluno1= new Aluno("Ivan",25,"ivan@mail.pt","Informática",15);
        Aluno aluno2= new Aluno("Joaquim",30,"quim@mail.pt","Design",14);

        if(aluno1.situacaoAprovacao() && aluno2.situacaoAprovacao()){
            System.out.println("Ambos aprovados");
        }

        aluno1.exibirDetalhes();
        aluno2.exibirDetalhes();
    }
}