package PraticasJava2;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int horas, minutos;

        // Ler horas e minutos - formato 24h
        System.out.print("Insira as horas (0 - 24): ");
        horas = input.nextInt();

        System.out.println("Insira os minutos (0 - 59): ");
        minutos = input.nextInt();

        // Converter para formato 12

        if (horas <= 12) {
            // Manhã
            System.out.println(horas + ":" + minutos + " AM");
        } else {
            // Tarde
            horas = horas - 12;
            System.out.println(horas + ":" + minutos + " PM");
        }

    }
}