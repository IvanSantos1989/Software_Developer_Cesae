package Cesaeland.Tools;

import Cesaeland.Models.Atracao;
import Cesaeland.Models.User;
import Cesaeland.Models.Venda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVFileReader {

    public ArrayList<Atracao> atracoesFileReader(String filePath1, String filePath2) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File atracoessFile = new File(filePath1);
        Scanner atracoessScanner = new Scanner(atracoessFile);

        // Criamos o ArrayList de Vendas, vazio
        ArrayList<Atracao> atracoessArray = new ArrayList<>();

        // Avançar o cabeçalho
        atracoessScanner.nextLine();

        // Abrimos o ficheiro e criamos um Scanner associado
        File atracoessFile2 = new File(filePath2);
        Scanner atracoessScanner2 = new Scanner(atracoessFile2);

        // Criamos o ArrayList de Vendas, vazio
        ArrayList<Atracao> atracoessArray2 = new ArrayList<>();

        // Avançar o cabeçalho
        atracoessScanner2.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (atracoessScanner.hasNextLine() && atracoessScanner2.hasNextLine()) {

            // Apanhamos a linha
            String linha = atracoessScanner.nextLine();

            // Separamos a linha, com base no seu separador ","
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações do ficheiro 1
            int idAtracao = Integer.parseInt(linhaSeparada[0]);
            String nome = linhaSeparada[1];
            double precoAdulto = Double.parseDouble(linhaSeparada[2]);
            double precoCrianca = Double.parseDouble(linhaSeparada[3]);
            double duracaoSegundos = Double.parseDouble(linhaSeparada[4]);


            // Reunir todas as informações do ficheiro 2

            // Apanhamos a linha
            String linhaFicheiro2 = atracoessScanner2.nextLine();

            // Separamos a linha, com base no seu separador ";"
            String[] linhaSeparadaFicheiro2 = linha.split(";");

            double custoManutencaoBilhete = Double.parseDouble(linhaSeparadaFicheiro2[1]);
            double custoFixoMes = Double.parseDouble(linhaSeparadaFicheiro2[2]);


            // Criar nova Atracao
            Atracao newAtracao = new Atracao(idAtracao, nome, precoAdulto, precoCrianca, duracaoSegundos, custoManutencaoBilhete, custoFixoMes);

            // Adicionamos ao Array
            atracoessArray.add(newAtracao);

        }

        // Terminando o ciclo (não há mais linhas)
        return atracoessArray;
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

    public ArrayList<Venda> vendasFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File vendasFile = new File(filePath);
        Scanner vendasScanner = new Scanner(vendasFile);

        // Criamos o ArrayList de Utilizadores, vazio
        ArrayList<Venda> vendasArray = new ArrayList<>();

        // Avançar o cabeçalho
        vendasScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (vendasScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = vendasScanner.nextLine();

            // Separamos a linha, com base no seu separador ";"
            String[] linhaSeparada = linha.split(";");

            // Reunir todas as informações da Venda
            int idAtracao = Integer.parseInt(linhaSeparada[0]);
            int data = Integer.parseInt(linhaSeparada[1]);
            String tipoCliente = linhaSeparada[2];

            // Criar novo Utilizador
            Venda newVenda = new Venda(idAtracao,data,tipoCliente);

            // Adicionamos ao Array
            vendasArray.add(newVenda);

        }

        // Terminando o ciclo (não há mais linhas)
        return vendasArray;
    }

}

