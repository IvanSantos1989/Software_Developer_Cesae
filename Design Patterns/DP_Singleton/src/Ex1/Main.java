package Ex1;

public class Main {
    public static void main(String[] args) {

        DatabaseConnection db1 = DatabaseConnection.getInstance("localhost:8000", "USER", "PASS");
        db1.connect();

        DatabaseConnection db2 = DatabaseConnection.getInstance("localhost:8000", "IVAN", "12345");
        db2.connect();

        System.out.println("___________________________________________________________");
        System.out.println(db1.getPassword());
        System.out.println(db2.getPassword());
        System.out.println("___________________________________________________________");

        db2.setPassword("999");

        System.out.println("___________________________________________________________");
        System.out.println(db1.getPassword());
        System.out.println(db2.getPassword());
        System.out.println("___________________________________________________________");
    }
}