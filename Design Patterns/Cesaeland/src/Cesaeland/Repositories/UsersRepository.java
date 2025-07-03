package Cesaeland.Repositories;

import Cesaeland.Models.User;
import Cesaeland.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UsersRepository {

    private ArrayList<User> usersArray;

    public UsersRepository() throws FileNotFoundException {

        CSVFileReader csvFR = new CSVFileReader();

        this.usersArray = csvFR.usersFileReader("Files/Cesaeland_logins.csv");
    }

    public ArrayList<User> getUsersArray() {
        return usersArray;
    }
}
