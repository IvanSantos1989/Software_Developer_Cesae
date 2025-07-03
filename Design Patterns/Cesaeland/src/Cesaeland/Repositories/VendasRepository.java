package Cesaeland.Repositories;

import Cesaeland.Models.Venda;
import Cesaeland.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class VendasRepository {

    private ArrayList<Venda> vendasArray;

    public VendasRepository(ArrayList<Venda> vendasArray) throws FileNotFoundException {

        CSVFileReader csvFR = new CSVFileReader();

        this.vendasArray = csvFR.vendasFileReader("Files/Cesaeland_vendas.csv");
    }

    public ArrayList<Venda> getVendasArray() {
        return vendasArray;
    }
}
