package PraticasJava1;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite o código do funcionário: ");
        String codigo = input.nextLine();

        System.out.print("Digite o número de dias trabalhados: ");
        int dias = input.nextInt();

        // Constantes
        final double VENCIMENTO_POR_DIA = 40.0;
        final double SUBSIDIO_POR_DIA = 5.0;
        final double IRS = 0.10;
        final double SEG_SOC_FUNC = 0.11;
        final double SEG_SOC_EMPRESA = 0.2375;

        // Cálculos
        double vencimentoBruto = VENCIMENTO_POR_DIA * dias;
        double subsidioAlimentacao = SUBSIDIO_POR_DIA * dias;

        double retencaoIRS = vencimentoBruto * IRS;
        double segurancaSocialFuncionario = vencimentoBruto * SEG_SOC_FUNC;
        double segurancaSocialEmpresa = vencimentoBruto * SEG_SOC_EMPRESA;

        double totalSegurancaSocial = segurancaSocialFuncionario + segurancaSocialEmpresa;

        double salarioLiquido = vencimentoBruto - retencaoIRS - segurancaSocialFuncionario;
        double valorFinalReceber = salarioLiquido + subsidioAlimentacao;

        // Saídas
        System.out.println("\n===== RESUMO DO SALÁRIO =====");
        System.out.println("Funcionário: " + codigo);
        System.out.printf("a. Vencimento líquido: %.2f€\n", salarioLiquido);
        System.out.printf("b. Total do subsídio de alimentação: %.2f€\n", subsidioAlimentacao);
        System.out.printf("c. Retenção de IRS: %.2f€\n", retencaoIRS);
        System.out.printf("d. Total Segurança Social (func. + empresa): %.2f€\n", totalSegurancaSocial);
        System.out.printf("e. Valor líquido final a receber: %.2f€\n", valorFinalReceber);
    }
}