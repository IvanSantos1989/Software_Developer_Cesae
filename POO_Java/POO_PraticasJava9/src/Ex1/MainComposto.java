package Ex1;

import java.util.Scanner;

public class MainComposto {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("_*_*_*_*_*_*_*_*_*_*_ Corridas Fantásticas _*_*_*_*_*_*_*_*_*_*_");

        System.out.println("___ Crie o seu carro ___");
        System.out.print("Marca: ");
        String marcaInput = input.nextLine();

        System.out.print("Modelo: ");
        String modeloInput = input.nextLine();

        System.out.print("Cor: ");
        String corInput = input.nextLine();

        System.out.print("Ano de Fabrico: ");
        int anoFabricoInput = input.nextInt();

        System.out.print("Potência CV: ");
        int potenciaCvInput = input.nextInt();

        System.out.print("CC: ");
        int ccInput = input.nextInt();

        System.out.println("O teu carro anda a gasolina e consome 10 L/100Km");

        Carro carroUtilizador = new Carro(marcaInput,modeloInput,corInput,anoFabricoInput,potenciaCvInput,ccInput,TipoCombustivel.GASOLINA,10);
        Carro ferrari = new Carro("Ferrari","Sf90","Vermelho",2022,80,5000,TipoCombustivel.GASOLINA,25);
        Carro mazda = new Carro("Mazda","MX-30","Cinza",2020,120,1500,TipoCombustivel.DIESEL,7);
        Carro papaReformas = new Carro("Papa","Reformas","Vermelho e Verde",1950,1350,2000,TipoCombustivel.GPL,2.5);

        System.out.println("Corrida 1: ");
        carroUtilizador.ligar();
        ferrari.ligar();

        Carro vencedor1 = carroUtilizador.corrida(ferrari);
        System.out.println("Vencedor da 1º corrida: ");
        vencedor1.exibirDetalhes();

        System.out.println("\n\nCorrida 2:");
        mazda.ligar();
        papaReformas.ligar();

        Carro vencedor2 = mazda.corrida(papaReformas);
        System.out.println("Vencedor da 2º corrida: ");
        vencedor2.exibirDetalhes();

        System.out.println("\n\nCorrida Final:");
        vencedor1.ligar();
        vencedor2.ligar();

        Carro vencedorFinal = vencedor1.corrida(vencedor2);
        System.out.println("Vencedor da corrida final: ");
        vencedorFinal.exibirDetalhes();
    }
}