package PraticasJava2;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int opcao;

        // Listar as opções
        System.out.println("***** Menu *****");
        System.out.println("1. Criar");
        System.out.println("2. Atualizar");
        System.out.println("3. Eliminar");
        System.out.println("4. Sair");

        // Ler opcao
        System.out.print("Insira a sua opção: ");
        opcao= input.nextInt();

        switch (opcao){
            case 1:
                System.out.println("CRIAR");
                break;

            case 2:
                System.out.println("ATUALIZAR");
                break;

            case 3:
                System.out.println("ELIMINAR");
                break;

            case 4:
                break;

            default:
                System.out.println("Opção Inválida");
                break;
        }

    }
}