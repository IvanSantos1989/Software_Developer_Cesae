package PraticasJava1;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int totalSegundos = 0, minutosLidos, segundosLidos;

        // Ler musicas
        System.out.print("Insira minutos da música 1: ");
        minutosLidos = input.nextInt();

        System.out.print("Insira segundos da música 1: ");
        segundosLidos = input.nextInt();

        totalSegundos = totalSegundos + segundosLidos + (minutosLidos * 60);

        // ________________________________________________________
        System.out.print("\nInsira minutos da música 2: ");
        minutosLidos = input.nextInt();

        System.out.print("Insira segundos da música 2: ");
        segundosLidos = input.nextInt();

        totalSegundos = totalSegundos + segundosLidos + (minutosLidos * 60);

        // ________________________________________________________
        System.out.print("\nInsira minutos da música 3: ");
        minutosLidos = input.nextInt();

        System.out.print("Insira segundos da música 3: ");
        segundosLidos = input.nextInt();

        totalSegundos = totalSegundos + segundosLidos + (minutosLidos * 60);

        System.out.println("\nTotal Segundos: " + totalSegundos);

        // Converter em horas, minutos e segundos
        int horas, minutos, segundos;

        horas = totalSegundos / 3600;

        minutos = (totalSegundos / 60) - (horas * 60);

        segundos = totalSegundos - (horas * 3600) - (minutos * 60);

        System.out.println("\nHoras: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);
    }
}