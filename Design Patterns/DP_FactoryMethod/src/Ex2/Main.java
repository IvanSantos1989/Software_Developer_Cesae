package Ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Escolha o tipo de taco (Carne, Frango ou Vegetariano): ");
        String tipo = input.nextLine();

        Taco taco = TacoFactory.criarTaco(tipo);

        if (taco != null) {
            taco.prepare();
            taco.bake();
            taco.box();
        } else {
            System.out.println("Tipo de taco inválido.");
        }
    }
}
