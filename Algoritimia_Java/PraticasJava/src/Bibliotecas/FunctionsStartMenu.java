package Bibliotecas;

import ProjetoIMDV.AdminMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FunctionsStartMenu {
    /**
     * Função que verifica se o utilizador e a password estão corretos
     *
     * @param path       Caminho para o ficheiro de credenciais
     * @param utilizador Nome de utilizador
     * @param password   Password do utilizador
     * @return true se as credenciais estiverem corretas, false caso contrário
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static boolean matchLoginPassword(String path, String utilizador, String password) throws FileNotFoundException {
        File ficheiro = new File(path);
        Scanner reader = new Scanner(ficheiro);

        while (reader.hasNextLine()) {
            String linha = reader.nextLine();
            String[] credenciais = linha.split(";");

            if (credenciais.length == 2) {
                String user = credenciais[0].trim();
                String pass = credenciais[1].trim();

                if (user.equals(utilizador) && pass.equals(password)) {
                    reader.close();
                    return true; // Acesso permitido
                }
            }
        }

        reader.close();
        return false; // Acesso negado
    }
}