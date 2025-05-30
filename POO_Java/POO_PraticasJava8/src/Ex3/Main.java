package Ex3;

public class Main {
    public static void main(String[] args) {

        Retangulo rt1 = new Retangulo("Laranja",10,5);

        System.out.println("Perimetro: "+rt1.calcularPerimetro());
        System.out.println("Área: "+rt1.calcularArea());


        Retangulo rt2 = new Retangulo("Branco",4,500);

        System.out.println("Perimetro: "+rt2.calcularPerimetro());
        System.out.println("Área: "+rt2.calcularArea());

    }
}