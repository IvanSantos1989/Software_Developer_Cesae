package Ex3;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        UserSessionManager session = UserSessionManager.getInstance();
        System.out.println("Token: " + session.getSessionToken());
        System.out.println("Last Access: " + session.getLastAccess());

        Thread.sleep(1000); // Simula passagem de tempo
        session.updateLastAccess();
        System.out.println("Updated Last Access: " + session.getLastAccess());
    }
}