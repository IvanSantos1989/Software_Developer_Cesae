package GrandesNegocios.Views;

import GrandesNegocios.Controllers.StaffController;

import java.util.Scanner;

public class StaffView {
    private StaffController staffController;

    public StaffView() {
        this.staffController= new StaffController();

    }

    public void staffMenu(){
        Scanner input = new Scanner(System.in);
        int opcaoStaff;

        do {

            System.out.println("\n\n********** MENU STAFF **********");
            System.out.println("1. Adicionar Venda");
            System.out.println("2. Consultar Stock");
            System.out.println("0. Voltar");

            System.out.print("\nOpção: ");
            opcaoStaff= input.nextInt();

            switch (opcaoStaff){
                case 1:
                    break;

                case 2:
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        }while (opcaoStaff!=0);
    }
}