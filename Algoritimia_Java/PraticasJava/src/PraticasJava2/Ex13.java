package PraticasJava2;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int horas, minutos;
        String periodo;

        System.out.print("Introduza horas: ");
        horas = input.nextInt();

        System.out.print("Introduza minutos: ");
        minutos = input.nextInt();

        // Define AM ou PM
        if (horas < 12) {
            periodo = "AM";
        } else {
            periodo = "PM";
        }

        // Converte para formato 12h
        if (horas == 0) {
            horas = 12;
        } else if (horas > 12) {
            horas = horas - 12;
        }

        // Mostra o resultado
        System.out.println(horas + ":" + minutos + " " + periodo);

    }
}