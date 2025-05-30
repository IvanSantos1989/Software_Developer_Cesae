package Ex5;

public class Main {
    public static void main(String[] args) {

        Carro mercedes = new Carro("Mercedes", "A45", "Branco", 2024);
        Carro fiat = new Carro("Fiat", "500", "Rosa", 2020);


        mercedes.ligar();
        fiat.ligar();

    }
}