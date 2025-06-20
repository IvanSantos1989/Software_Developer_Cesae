package Ex2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Logger l1 = new Logger("ficheiro.txt");
        l1.logarMensagem("O programa começou");
        l1.logarMensagem("Continua a executar...");
    }
}