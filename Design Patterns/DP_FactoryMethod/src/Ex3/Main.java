package Ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Tipo de documento (texto, folha de cálculo, apresentação): ");
        String tipo = input.nextLine();

        System.out.print("Nome do documento: ");
        String nome = input.nextLine();

        System.out.print("Autor do documento: ");
        String autor = input.nextLine();

        Document doc = DocumentFactory.createDocument(tipo, autor, nome);

        if (doc == null) {
            System.out.println("Tipo de documento inválido.");
            return;
        }

        System.out.print("Qual método deseja invocar? (open, save, close): ");
        String metodo = input.nextLine();

        switch (metodo.toLowerCase()) {
            case "open":
                doc.open();
                break;

            case "save":
                doc.save();
                break;

            case "close":
                doc.close();
                break;

            default:
                System.out.println("Método inválido.");
        }
    }
}