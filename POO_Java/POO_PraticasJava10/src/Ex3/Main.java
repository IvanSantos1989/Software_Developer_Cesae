package Ex3;

public class Main {
    public static void main(String[] args) {

        Peixe sardinha = new Peixe("Sardinha",75,12);
        Peixe bacalhau = new Peixe("Bacalhau",75,22.5);
        Peixe robalo = new Peixe("Robalo",20,25);
        Peixe peixeEspada = new Peixe("Peixe Espada",50,35);

        Marisco lagosta = new Marisco("Lagosta",10,90);
        Marisco ameijoa = new Marisco("Ameijoa",25,65);

        // Criar o barco - sem carga
        BarcoPesca marisol = new BarcoPesca("Marisol","Azul e Branco",1975,4,200,MarcaBarco.BENTZ);
        marisol.exibirDetalhes();


        // Pescar 2 peixes
        marisol.pescarPeixe(sardinha);
        marisol.pescarPeixe(bacalhau);

        marisol.exibirDetalhes();


        // Pescar 2 mariscos
        marisol.pescarMarisco(lagosta);
        marisol.pescarMarisco(ameijoa);

        marisol.exibirDetalhes();


        // Largar as sardinhas
        marisol.largarPeixe(sardinha);

        marisol.exibirDetalhes();


        // Pescar mais alguma coisa
        marisol.pescarPeixe(robalo);
        marisol.pescarPeixe(peixeEspada);

        marisol.exibirDetalhes();

    }
}