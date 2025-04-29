package PraticasJava3;

public class Ex2_v2 {
    public static void main(String[] args) {

        int numero = 2;

        while (numero <= 400) {
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
            numero = numero + 1;
        }
    }
}