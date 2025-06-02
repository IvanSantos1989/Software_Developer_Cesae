package Ex4;

public class Imovel {
    private String rua;
    private String numPorta;
    private String cidade;
    private TipoImovel tipologia;
    private AcabamentoImovel acabamento;
    private double areaTotal;
    private int numQuartos;
    private int numWCs;
    private double areaPiscina;

    public Imovel(String rua, String numPorta, String cidade, TipoImovel tipologia, AcabamentoImovel acabamento, double areaTotal, int numQuartos, int numWCs, double areaPiscina) {
        this.rua = rua;
        this.numPorta = numPorta;
        this.cidade = cidade;
        this.tipologia = tipologia;
        this.acabamento = acabamento;
        this.areaTotal = areaTotal;
        this.numQuartos = numQuartos;
        this.numWCs = numWCs;
        this.areaPiscina = areaPiscina;
    }

    public double calcularValor() {
        double valorTotal = 0;

        // Incrementar os quartos;
        valorTotal += this.numQuartos * 7500;

        // Incrementar os WCs
        valorTotal += this.numWCs * 10500;

        // Incrementar a piscina
        valorTotal += this.areaPiscina * 1000;

        // Incrementar a área
        switch (this.tipologia) {
            case APARTAMENTO:
                valorTotal += this.areaTotal * 1000;
                break;

            case CASA:
                valorTotal += this.areaTotal * 3000;
                break;

            case MANSAO:
                valorTotal += this.areaTotal * 5000;
                break;
        }

        // Aplicar o desconto
        switch (this.acabamento) {
            case PARA_RESTAURO:
                valorTotal *= 0.5;
                break;

            case USADA:
                valorTotal *= 0.9;
                break;

            case NOVA:
                valorTotal = valorTotal; // Mantém o preço
                break;

            case NOVA_COM_ALTO_ACABAMENTO:
                valorTotal *= 1.25;
                break;
        }

        return valorTotal;
    }

    public Imovel compararImoveis(Imovel imovelComparado) {
        if (this.calcularValor() > imovelComparado.calcularValor()) {
            return this;
        } else {
            return imovelComparado;
        }
    }

    public void exibirDetalhes() {
        System.out.println("Morada: " + this.rua + " | Nº: " + this.numPorta);
        System.out.println(this.tipologia + " | " + this.acabamento);
    }

}