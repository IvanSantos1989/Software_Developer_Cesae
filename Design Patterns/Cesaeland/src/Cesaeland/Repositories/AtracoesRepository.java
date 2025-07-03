package Cesaeland.Repositories;

import Cesaeland.Models.Atracao;
import Cesaeland.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AtracoesRepository {
    private ArrayList<Atracao> atracaoArray;

    public AtracoesRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();

        this.atracaoArray = csvFR.atracoesFileReader("Files/Cesaeland_atracoes.csv", "Files/Cesaeland_custos.csv");
                // csvFR.salesFileReader("Files/minimercado(in).csv");
    }

    public ArrayList<Atracao> getAtracaoArray() {
        return atracaoArray;
    }
}
