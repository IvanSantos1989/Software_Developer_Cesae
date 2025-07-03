package Cesaeland.Views;

public class MensagemView {
    public void mostrarMensagemErro(String msg) {
        System.out.println("❌ ERRO: " + msg);
    }

    public void mostrarMensagemSucesso(String msg) {
        System.out.println("✅ SUCESSO: " + msg);
    }

    public void mostrarMensagemInfo(String msg) {
        System.out.println("ℹ️ INFO: " + msg);
    }
}