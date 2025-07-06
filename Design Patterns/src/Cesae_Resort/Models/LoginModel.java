package Cesae_Resort.Models;

import java.util.ArrayList;
import java.io.*;

/** * Classe responsável por carregar e autenticar logins a partir de um ficheiro CSV.
 * Cada login contém um username, password e perfil (ex: Cliente, Rececionista, Guia, Administrador).
 */
public class LoginModel {
    private String ficheiroLogins = "Files/logins.csv";

    public ArrayList<Login> carregarLogins() {
        ArrayList<Login> logins = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ficheiroLogins))) {
            String linha;
            br.readLine(); // Ignora cabeçalho
            while ((linha = br.readLine()) != null) {
                if (linha.isEmpty()) continue;
                String[] partes = linha.split(",");
                String username = partes[0];
                String password = partes[1];
                String perfil = partes[2];
                logins.add(new Login(username, password, perfil));
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler logins: " + e.getMessage());
        }
        return logins;
    }

    // Valida as credenciais e devolve o perfil, ou null se inválido
    public String autenticar(String username, String password) {
        ArrayList<Login> logins = carregarLogins();
        for (Login login : logins) {
            if (login.getUsername().equals(username) && login.getPassword().equals(password)) {
                return login.getPerfil();
            }
        }
        return null;
    }
}