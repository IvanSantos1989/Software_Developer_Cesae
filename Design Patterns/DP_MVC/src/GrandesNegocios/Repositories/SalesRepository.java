package GrandesNegocios.Repositories;

import GrandesNegocios.Models.Sale;
import GrandesNegocios.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SalesRepository {

    private ArrayList<Sale> salesArray;

    public SalesRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();

        this.salesArray = csvFR.salesFileReader("Files/minimercado.csv");
    }

    public ArrayList<Sale> getSalesArray() {
        return salesArray;
    }
}