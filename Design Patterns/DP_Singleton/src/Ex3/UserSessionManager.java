package Ex3;

import java.util.Random;

public class UserSessionManager {

    private static UserSessionManager instance;
    private int sessionToken;
    private String lastAccess;

    private UserSessionManager() {
        this.sessionToken = new Random().nextInt(Integer.MAX_VALUE);
        this.lastAccess = String.valueOf(System.currentTimeMillis());
    }

    public static UserSessionManager getInstance() {
        if (instance == null) {
            instance = new UserSessionManager();
        }
        return instance;
    }

    public int getSessionToken() {
        return sessionToken;
    }

    public String getLastAccess() {
        return lastAccess;
    }

    public void updateLastAccess() {
        this.lastAccess = String.valueOf(System.currentTimeMillis());
    }
}