package GrandesNegocios.Repositories;

import GrandesNegocios.Models.User;
import GrandesNegocios.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UsersRepository {

    private ArrayList<User> userArray;

    public UsersRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();

        this.userArray= csvFR.usersFileReader("Files/login_grandesNegocios.csv");
    }

    public ArrayList<User> getUserArray() {
        return userArray;
    }
}