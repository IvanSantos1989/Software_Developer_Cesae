package PraticasJava3;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numero, contador025 = 0, contador2650 = 0, contador5175 = 0, contador76100 = 0;

        System.out.print("Digite um número: ");
        numero = input.nextInt();


        while (numero >= 0){

        if (numero <= 25) {
                contador025 += 1;
            }
            else if (numero <= 50){
                contador2650 += 1;
            }
            else if (numero <= 75) {
                contador5175 += 1;
            }
            else {
                contador76100 += 1;
            }

            System.out.print("Digite um número: ");
            numero = input.nextInt();

        }

        System.out.println("0-25: " + contador025);
        System.out.println("26-50: " + contador2650);
        System.out.println("51-75: " + contador5175);
        System.out.println("76-100: " + contador76100);
    }
}