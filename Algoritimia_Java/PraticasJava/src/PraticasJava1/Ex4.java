package PraticasJava1;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        double raio, circunferencia, area;

        // Ler raio
        System.out.print("Insira o raio: ");
        raio = input.nextDouble();

        // Calcular e apresentar a circunferencia
        circunferencia = 2 * 3.14 * raio;
        System.out.println("Circunferencia: " + circunferencia);

        // Calcular e apresentar a area
        area = 3.14 * raio * raio;
        System.out.println("Área: " + area);
    }
}
