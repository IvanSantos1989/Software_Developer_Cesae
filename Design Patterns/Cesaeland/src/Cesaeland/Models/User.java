package Cesaeland.Models;

public class User {
    private String tipoConta;
    private String username;
    private String password;

    public User(String tipoConta, String username, String password) {
        this.tipoConta = tipoConta;
        this.username = username;
        this.password = password;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
