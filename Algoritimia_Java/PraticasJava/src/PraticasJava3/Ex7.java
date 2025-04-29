package PraticasJava3;

public class Ex7 {
    public static void main(String[] args) {

        int numero = 1, soma = 0;

        while (numero <= 100){
            System.out.println(numero);
            soma = soma + numero;
            numero += 1;
        }
        System.out.println("Soma = " + soma);
    }
}