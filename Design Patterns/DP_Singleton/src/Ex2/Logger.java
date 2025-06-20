package Ex2;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private String caminhoFicheiro;

    public Logger(String caminhoFicheiro) {
        this.caminhoFicheiro = caminhoFicheiro;
    }

    public void logarMensagem(String mensagem) throws IOException {
        FileWriter fw = new FileWriter(this.caminhoFicheiro, true);
        fw.append(mensagem + "\n");
        fw.close();
    }
}