package Ex1;

public class Main {
    public static void main(String[] args) {
        Carro fiat = new Carro("Fiat","500","Rosa",1960,100,1000,TipoCombustivel.GASOLINA,20);
        Carro ferrari = new Carro("Ferrari","Sf90","Vermelho",2022,800,5000,TipoCombustivel.GASOLINA,25);
        Carro mazda = new Carro("Mazda","MX-30","Cinza",2020,120,1500,TipoCombustivel.DIESEL,7);
        Carro papaReformas = new Carro("Papa","Reformas","Vermelho e Verde",1950,1350,2000,TipoCombustivel.GPL,2.5);

        Carro vencedor1 = fiat.corrida(ferrari);
        Carro vencedor2 = mazda.corrida(papaReformas);

        Carro vencedorFinal = vencedor1.corrida(vencedor2);

        vencedorFinal.exibirDetalhes();
    }
}