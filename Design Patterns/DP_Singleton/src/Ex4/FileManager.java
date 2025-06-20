package Ex4;

import java.io.File;
import java.io.IOException;

public class FileManager {
    private static FileManager instance;
    private String rootDirectory;

    private FileManager() {
        this.rootDirectory = "";
    }

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public void setRootDirectory(String rootDirectory) {
        this.rootDirectory = rootDirectory;
        File dir = new File(rootDirectory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public boolean createFile(String fileName) {
        File file = new File(rootDirectory, fileName);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFile(String fileName) {
        File file = new File(rootDirectory, fileName);
        return file.delete();
    }
}