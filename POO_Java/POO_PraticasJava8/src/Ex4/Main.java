package Ex4;

public class Main {
    public static void main(String[] args) {

        Circulo c1 = new Circulo("Vermelho", 5.0);
        System.out.println("Perímetro do círculo: " + c1.calcularPerimetro());
        System.out.println("Área do círculo: " + c1.calcularArea());

        Circulo c2 = new Circulo("Azul", 10.0);
        System.out.println("Perímetro do círculo: " + c2.calcularPerimetro());
        System.out.println("Área do círculo: " + c2.calcularArea());
    }
}
