package Ex4;

public class Main {
    public static void main(String[] args) {

        Imovel imovel1 = new Imovel("Rua do Sol", "144", "Porto", TipoImovel.APARTAMENTO, AcabamentoImovel.USADA, 140, 2, 2, 0);
        Imovel imovel2 = new Imovel("Rua Palácio dos Reis", "1", "Lisboa", TipoImovel.MANSAO, AcabamentoImovel.NOVA_COM_ALTO_ACABAMENTO, 220, 5, 6, 25);

        System.out.println("Valor 1º imóvel: " + imovel1.calcularValor());
        System.out.println("Valor 2º imóvel: " + imovel2.calcularValor());


        System.out.println("________________________________________________");
        System.out.println("Mais Caro: ");
        Imovel imovelMaisCaro = imovel1.compararImoveis(imovel2);
        imovelMaisCaro.exibirDetalhes();
    }
}