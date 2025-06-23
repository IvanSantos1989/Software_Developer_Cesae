package GrandesNegocios.Tools;

import GrandesNegocios.Models.Sale;
import GrandesNegocios.Models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVFileReader {

    public ArrayList<Sale> salesFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File salesFile = new File(filePath);
        Scanner salesScanner = new Scanner(salesFile);

        // Criamos o ArrayList de Vendas, vazio
        ArrayList<Sale> salesArray = new ArrayList<>();

        // Avançar o cabeçalho
        salesScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (salesScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = salesScanner.nextLine();

            // Separamos a linha, com base no seu separador ","
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações da Venda
            String tipoProduto = linhaSeparada[0];
            String produto = linhaSeparada[1];
            double quantidadeVendida = Double.parseDouble(linhaSeparada[2]);
            double precoUnitario = Double.parseDouble(linhaSeparada[3]);

            // Criar nova Venda
            Sale newSale = new Sale(tipoProduto,produto,quantidadeVendida,precoUnitario);

            // Adicionamos ao Array
            salesArray.add(newSale);

        }

        // Terminando o ciclo (não há mais linhas)
        return salesArray;
    }

    public ArrayList<User> usersFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File usersFile = new File(filePath);
        Scanner usersScanner = new Scanner(usersFile);

        // Criamos o ArrayList de Utilizadores, vazio
        ArrayList<User> usersArray = new ArrayList<>();

        // Avançar o cabeçalho
        usersScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (usersScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = usersScanner.nextLine();

            // Separamos a linha, com base no seu separador ";"
            String[] linhaSeparada = linha.split(";");

            // Reunir todas as informações da Venda
            String tipoConta = linhaSeparada[0];
            String username= linhaSeparada[1];
            String password= linhaSeparada[2];

            // Criar novo Utilizador
            User newUser = new User(tipoConta,username,password);

            // Adicionamos ao Array
            usersArray.add(newUser);

        }

        // Terminando o ciclo (não há mais linhas)
        return usersArray;
    }
}