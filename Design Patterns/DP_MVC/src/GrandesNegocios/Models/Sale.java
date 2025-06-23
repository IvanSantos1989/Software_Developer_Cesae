package GrandesNegocios.Models;

public class Sale {
    private String tipoProduto;
    private String nomeProduto;
    private double quantidadeVendida;
    private double precoUnitario;

    public Sale(String tipoProduto, String nomeProduto, double quantidadeVendida, double precoUnitario) {
        this.tipoProduto = tipoProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeVendida = quantidadeVendida;
        this.precoUnitario = precoUnitario;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}