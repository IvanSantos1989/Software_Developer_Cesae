package Ex1;

public class DatabaseConnection {

    // Atributo de Classe - Local de armazenamento para o único objeto que vai existir desta classe
    private static DatabaseConnection instance;

    // Atributos de instância - Atributos "normais" que estamos habituados
    private String connectionString;
    private String username;
    private String password;

    // Construtor "normal", fica privado
    private DatabaseConnection(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username=username;
        this.password=password;
    }

    // Construtor tuning, que permite controlar se criamos o primeiro objeto (novo) ou retornamos o que já existe
    public static DatabaseConnection getInstance(String connectionString, String username, String password){
        if(instance==null){
            instance= new DatabaseConnection(connectionString,username,password);
        }

        return instance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void connect() {
        // Código para conectar à base de dados usando a connectionString
        System.out.println("Conectado à base de dados: " + connectionString);
    }

    public void disconnect() {
        // Código para desconectar da base de dados
        System.out.println("Desconectado da base de dados: " + connectionString);
    }
}