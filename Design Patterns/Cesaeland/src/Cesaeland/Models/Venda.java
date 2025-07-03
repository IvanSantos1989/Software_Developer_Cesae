package Cesaeland.Models;

public class Venda {
    private int idAtracao;
    private int data; // MM/AAAA
    private String tipoCliente;

    public Venda(int idAtracao, int data, String tipoCliente) {
        this.idAtracao = idAtracao;
        this.data = data;
        this.tipoCliente = tipoCliente;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public int getData() {
        return data;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }
}
