package PraticasJava6;

import java.util.Scanner;

public class Ex1 {
    public static void fazerBarulho(String animal){

        switch (animal){
            case "Cão":
                System.out.println("Au au au ");
                break;

            case "Gato":
                System.out.println("Miau!");
                break;

            case "Peixe":
                System.out.println("Glub glub");
                break;

            default:
                System.out.println("Barulho desconhecido...");
        }
    }

    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        String animalUtilizador;

        System.out.print("Insira um animal: ");
        animalUtilizador=input.next();

        fazerBarulho(animalUtilizador);
    }
}