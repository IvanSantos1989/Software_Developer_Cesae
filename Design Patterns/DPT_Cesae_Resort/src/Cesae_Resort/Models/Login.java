package Cesae_Resort.Models;

/**
 * Classe que representa um login no sistema CESAE Resort.
 * Contém informações sobre o usuário, senha e perfil (ex: Cliente, Rececionista, Guia, Administrador).
 */
public class Login {
    private String username;
    private String password;
    private String perfil;

    public Login(String username, String password, String perfil) {
        this.username = username;
        this.password = password;
        this.perfil = perfil;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getPerfil() { return perfil; }
}