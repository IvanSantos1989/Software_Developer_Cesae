package GrandesNegocios.Views;

import GrandesNegocios.Controllers.AdminController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminView {
    private AdminController adminController;

    public AdminView() throws FileNotFoundException {
        this.adminController= new AdminController();
    }

    public void adminMenu(){
        Scanner input = new Scanner(System.in);
        int opcaoAdmin;

        do {

            System.out.println("\n\n********** MENU ADMIN **********");
            System.out.println("1. Produto Mais Vendido - Unidades");
            System.out.println("2. Produto Mais Vendido - Valor Vendas");
            System.out.println("3. Melhor Venda - Unidades");
            System.out.println("4. Melhor Venda - Valor");
            System.out.println("5. Total Vendas");
            System.out.println("6. Média Vendas");
            System.out.println("0. Voltar");

            System.out.print("\nOpção: ");
            opcaoAdmin= input.nextInt();

            switch (opcaoAdmin){
                case 1: // Produto Mais Vendido - Unidades
                    break;

                case 2:
                    break;


                case 3:
                    break;


                case 4:
                    break;

                case 5: // Total Vendas
                    System.out.println("\n***** Total Vendas *****");
                    System.out.println(this.adminController.totalSalesValue()+" €");
                    break;

                case 6:
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        }while (opcaoAdmin!=0);
    }
}